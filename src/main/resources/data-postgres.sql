insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Mikronaselje', 'Blok A1');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Heroja Pinkija', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Evrope', '58');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Cara Lazara', '101');
insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Sumica 15', '22A');

insert into role (name) values ('ROLE_CLIENT');
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_COTTAGE_OWNER');
insert into role (name) values ('ROLE_SHIP_OWNER');
insert into role (name) values ('ROLE_INSTRUCTOR');

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('majstor','goran.tatomirov@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Goran', 'Tatomirov', '123456789', 1, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('gale','gale@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jovan', 'Gaspar', '123456789', 1, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('bojan','bojan@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Bojan', 'Skokic', '123456789', 1, TRUE);

insert into account_role (account_id, role_id) values (1,1);
insert into account_role (account_id, role_id) values (2,2);
insert into account_role (account_id, role_id) values (3,1);

insert into cottage_owner (account_id) values (1);

insert into availability_period(start_date, end_date) values(null, null);

insert into cottage (description, name, address_id, availability_period_id) values ('rezervisi bre', 'Najjaca vikendica', 2, 1);

insert into cottage_owner_cottages (cottage_owner_id, cottages_id) values (1, 1);