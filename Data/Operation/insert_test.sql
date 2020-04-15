insert into city (city_code, city_name, province_name)
values (110100, '北京市', '北京市');

insert into city (city_code, city_name, province_name)
values (120100, '天津市', '天津市');

insert into city (city_code, city_name, province_name)
values (330100, '杭州市', '浙江省');

insert into city (city_code, city_name, province_name)
values (440300, '深圳市', '广东省');

truncate table city;

-- Needed for self-increment
alter sequence users_user_id_seq start 1;