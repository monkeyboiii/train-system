create table city
(
    city_code     integer
        primary key,
    city_name     varchar,
    province_name varchar
);


create table station
(
    station_name varchar
        constraint station_pk
            primary key,
    station_code integer unique,
    city_code    integer not null
        constraint station_fk
            references city (city_code)
);


create table timetable
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


create table train_route
(
    route_id       serial  not null
        constraint train_route_pk
            primary key,
    train_code     varchar not null,
    depart_station varchar
        constraint train_route_fk
            references station (station_name),
    arrive_station varchar
        constraint train_route_fk_2
            references station (station_name),
    constraint train_route_unique
        unique (train_code, depart_station, arrive_station)
);


create table ticket_set
(
    ticket_set_id serial not null
        constraint ticket_set_pk
            primary key,
    train_code    varchar,
    route_id      integer
        constraint train_route_fk
            references train_route (route_id),
    seat_type     varchar,
    price         decimal(6, 2),
    ticket_date   date,
    remain        integer
);


create table ticket
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


-- reduce shadow naming
create table orders
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


-- reduce shadow naming
create table users
(
    user_id  serial  not null
        constraint users_pk
            primary key,
    username varchar,
    id       varchar unique,
    phone    varchar,
    password varchar not null
);