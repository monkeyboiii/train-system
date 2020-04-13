-- city
create table city
(
    city_code     integer not null
        constraint city_pk
            primary key,
    city_name     varchar,
    province_name varchar
);

alter table city
    owner to postgres;

create unique index city_city_code_uindex
    on city (city_code);



-- station
create table public.station
(
	station_code integer,
	station_name varchar not null
		constraint station_pk
			primary key,
	city_code integer not null
		constraint station_city__fk
			references public.city
);

alter table public.station owner to postgres;

create unique index station_station_code_uindex
	on public.station (station_code);

create unique index station_station_name_uindex
	on public.station (station_name);



-- timetable
create table public.timetable
(
	train_code varchar,
	station_name varchar,
	station_order integer,
	arrive_time time,
	depart_time time,
	arrive_day integer,
	constraint timetable_pk
		unique (train_code, station_name)
);

alter table public.timetable owner to postgres;



-- train_route
create table public.train_route
(
	route_id serial not null
		constraint train_route_pk
			primary key,
	train_code varchar,
	depart_station varchar,
	arrive_station varchar
);

alter table public.train_route owner to postgres;

create unique index train_route_route_id_uindex
	on public.train_route (route_id);

create unique index train_route_train_code_depart_station_arrive_station_uindex
	on public.train_route (train_code, depart_station, arrive_station);