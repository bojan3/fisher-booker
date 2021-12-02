insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Mikronaselje', 'Blok A1');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Heroja Pinkija', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Evrope', '58');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Cara Lazara', '101');
insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Sumica 15', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Banatsko Novo Selo', 'Oslobodjenja', '58');


insert into role (name) values ('CLIENT');
insert into role (name) values ('ADMIN');

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('Gale','goran.tatomirov@gmail.com', '123', 'Jovan', 'Gašpar', '123456789', 1, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('Gale','goran.tatomirov@gmail.com', '123', 'Jovan', 'Gašpar', '123456789', 1, TRUE);

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled) values ('majstor','goran.tatomirov@gmail.com', '123', 'Goran', 'Tatomirov', '123456789', 1, TRUE);

insert into account_role (account_id, role_id) values (1,1);
insert into account_role(account_id,role_id) values(2,2);

insert into cottage_owner (account_id) values (1);

insert into availability_period(start_date, end_date) values(null, null);

insert into cottage (description, name, address_id, availability_period_id) values ('rezervisi bre', 'Najjaca vikendica', 2, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Slike govore vise od reci', 'Villa Mirna', 3, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Zlatiborske lepote, veoma lep pogled', 'Villa Anja', 4, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Visoko u panini, zubori reka u blizini', 'Villa Smilja', 6, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('u kotlini, brza voda tece', 'Villa Tamara', 1, 1);
insert into cottage (description, name, address_id, availability_period_id) values ('Vikendica skrivena u sumi', 'Villa Zagorka', 5, 1);





insert into cottage_owner_cottages (cottage_owner_id, cottages_id) values (1, 1);