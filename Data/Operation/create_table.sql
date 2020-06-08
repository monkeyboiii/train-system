create table if not exists city
(
    city_code     integer
        primary key,
    city_name     varchar not null,
    province_name varchar not null
);


create table if not exists station
(
    station_name varchar
        primary key,
    station_code integer unique,
    city_code    integer not null
        constraint station_fk
            references city (city_code)
);


create table if not exists timetable
(
    train_code    varchar,
    station_name  varchar
        constraint timetable_fk
            references station (station_name),
    station_order integer not null,
    arrive_time   time,
    depart_time   time,
    arrive_day    integer,
    constraint timetable_pk
        primary key (train_code, station_name, station_order)
   	-- use three field to avoid roundabout train_route
);


create table if not exists route
(
    route_id serial  not null
            primary key,
    train_code     varchar not null,
    depart_station varchar
        constraint route_fk
            references station (station_name),
    arrive_station varchar
        constraint route_fk_2
            references station (station_name)
);

create table if not exists route_price
(
    rp_id serial  not null
            primary key,
	route_id int
		constraint route_price_fk
            references route (route_id),
	seat_type varchar not null,
	price double precision not null,
	total_num int not null

);

create table if not exists ticket_set
(
    ticket_set_id serial not null
        constraint ticket_set_pk
            primary key,
    rp_id      integer
        constraint ticket_price_fk
            references route_price (rp_id),
    ticket_date   date,
    remain        integer
);

-- reduce shadow naming
create table if not exists users
(
    user_id  serial  not null
        constraint users_pk
            primary key,
    username varchar,
    id       varchar unique,
    phone    varchar,
    password varchar not null
);

-- reduce shadow naming
create table if not exists orders
(
    order_id    serial not null
        constraint orders_pk
            primary key,
    create_time timestamp,
    status      varchar,
    user_id     integer
        constraint orders_fk
            references users (user_id)
);

create table if not exists ticket
(
    ticket_id     serial  not null
        constraint ticket_pk
            primary key,
    ticket_set_id integer
        constraint ticket_fk
            references ticket_set (ticket_set_id),
    seat_number   varchar not null,
    order_id      integer not null
        constraint ticket_fk_2
            references orders (order_id)
);


