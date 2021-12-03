insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Mikronaselje', 'Blok A1');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Heroja Pinkija', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Evrope', '58');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Cara Lazara', '101');
insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Sumica 15', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Banatsko Novo Selo', 'Oslobodjenja', '58');
insert into address (country, city, street, number) values ('Serbia', 'Beograd', 'Cara Dusana', '17-a');


insert into role (name) values ('ROLE_CLIENT');
insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_COTTAGE_OWNER');
insert into role (name) values ('ROLE_SHIP_OWNER');
insert into role (name) values ('ROLE_INSTRUCTOR');

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('majstor','goran.tatomirov@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Goran', 'Tatomirov', '123456789', 1, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('gale','gale@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jovan', 'Gaspar', '123456789', 1, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('bojan','bojan@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Bojan', 'Skokic', '123456789', 1, TRUE);

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('sasvimprirodno','jovopustolov@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jovan', 'Memedovic', '123456789', 7, TRUE);



insert into account_role (account_id, role_id) values (1,1);
insert into account_role (account_id, role_id) values (2,2);
insert into account_role (account_id, role_id) values (3,1);
insert into account_role (account_id, role_id) values (4,5);

insert into cottage_owner (account_id) values (1);
insert into fishing_instructor(account_id) values(4);


insert into adventure (account,name,description,capacity,price,cancel_rate) values (1,'Obilazak Djerdapske klisure','Ujutru se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2);



insert into availability_period(start_date, end_date) values(null, null);

insert into cottage (description, name, address_id, availability_period_id) values ('rezervisi bre', 'Najjaca vikendica', 2, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Slike govore vise od reci', 'Villa Mirna', 3, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Zlatiborske lepote, veoma lep pogled', 'Villa Anja', 4, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Visoko u panini, zubori reka u blizini', 'Villa Smilja', 6, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('u kotlini, brza voda tece', 'Villa Tamara', 1, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Vikendica skrivena u sumi', 'Villa Zagorka', 5, 1);

insert into cottage_owner_cottages (cottage_owner_id, cottages_id) values (1, 1);

insert into ship (name, type, length, description, average_mark,rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate) values ('Jahta Bosanka' , null, 3, 'Jahta za uzivanje', 5, 100, 10, 170, 150, 30, 0);
insert into ship (name, type, length, description, average_mark,rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate) values ('Jahta Jovana' , null, 3, 'Jahta za uzivanje', 3, 150, 20, 200, 100, 40, 0);
insert into ship (name, type, length, description, average_mark,rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate) values ('Jahta Katarina' , null, 3, 'Jahta za uzivanje', 7, 100, 30, 300, 150, 10, 0);
