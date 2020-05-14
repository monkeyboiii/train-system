-- From console.sql


-- Revoke primary key
SELECT setval(pg_get_serial_sequence('users', 'user_id'), coalesce(max(user_id), 0) + 1, false)
FROM users;


-- Station-city name only table: station-simple
create table station_simple
(
    station_name varchar
        constraint station_simple_pkey
            primary key,
    city_name    varchar
);
INSERT INTO station_simple (station_name, city_name)
    (SELECT s.station_name, c.city_name
     FROM station s
              join city c on s.city_code = c.city_code);


-- TicketSet
explain
select rp.route_id      route_id,
       ts.ticket_date   date,
       ts.ticket_set_id ticket_set_id,
       rp.seat_type     seat_type,
       rp.price         price,
       ts.remain        remain
from ticket_set ts
         join route_price rp on ts.rp_id = rp.rp_id
where rp.route_id = 1234
  and ts.ticket_date = '2020-05-21'::date;

-- Obsolete ticketSet
explain
with rp as (select * from route_price where route_id = 1234)
select rp.route_id      route_id,
       ts.ticket_date   date,
       ts.ticket_set_id ticket_set_id,
       rp.seat_type     seat_type,
       rp.price         price,
       ts.remain        remain
from (select *
      from ticket_set
      where ticket_date = '2020-05-21') ts
         join rp on ts.rp_id = rp.rp_id;


-- Route
with t as (select r.route_id,
                  r.depart_station,
                  r.arrive_station,
                  t.*
           from route r
                    join timetable t on r.train_code = t.train_code
           where r.depart_station = '杭州东'
             and r.arrive_station = '北京南'
             and t.station_name in ('杭州东', '北京南'))
select t1.route_id                                           route_id,
       t1.train_code                                         train_code,
       t1.depart_station                                     depart_station,
       t1.depart_time                                        depart_time,
       case (t1.depart_time is null)
           when true then '始'
           when false then '过' end                           depart_order,
       t2.arrive_station                                     arrive_station,
       t2.arrive_time                                        arrive_time,
       case (t2.arrive_time is null)
           when true then '过'
           when false then '终' end                           arrive_order,
       case (t2.arrive_day - t1.arrive_day is null)
           when true then 0
           when false then t2.arrive_day - t1.arrive_day end arrive_day
from t t1
         join t t2 on t1.route_id = t2.route_id and t1.station_name != t2.station_name
where t1.station_name = '杭州东'
  and t2.station_name = '北京南';


-- Transit Route
select a.train_code                train_code,
       a.depart_station            depart_station,
       b.arrive_station            arrive_station,
       a.depart_time
                                   depart_time,
       b.arrive_time               arrive_time,
       a.arrive_day + b.arrive_day arrive_day,
       b.train_code                transit_train_code,
       b.depart_station            transit_station,
       b.depart_time               transit_time
from (select a1.train_code                         train_code,
             a1.depart_station                     depart_station,
             a1.arrive_station                     arrive_station,
             a2.depart_time                        depart_time,
             a3.arrive_time                        arrive_time,
             case (a3.arrive_day is null)
                 when true then 0
                 when false then a3.arrive_day end arrive_day
      from (select * from route where depart_station = '固原') a1
               join timetable a2 on a1.train_code = a2.train_code and a1.depart_station = a2.station_name
               join timetable a3 on a1.train_code = a3.train_code and a1.arrive_station = a3.station_name) a
         join (select b1.train_code                         train_code,
                      b1.depart_station                     depart_station,
                      b1.arrive_station                     arrive_station,
                      b2.depart_time                        depart_time,
                      b3.arrive_time                        arrive_time,
                      case (b3.arrive_day is null)
                          when true then 0
                          when false then b3.arrive_day end arrive_day
               from (select * from route where arrive_station = '玉林') b1
                        join timetable b2 on b1.train_code = b2.train_code and b1.depart_station = b2.station_name
                        join timetable b3 on b1.train_code = b3.train_code and b1.arrive_station = b3.station_name) b
              on a.arrive_station = b.depart_station and b.depart_time - a.arrive_time > '0:20'
order by EXTRACT(Epoch from
                 (b.arrive_time - a.arrive_time + cast((a.arrive_day + b.arrive_day || 'days') as interval)))
limit 10;


-- Transit Route in function
select *
from transit_route_query('固原', '玉林');


-- Indexing, speed up dramatically
CREATE INDEX route_id_index
    ON route_price (route_id);