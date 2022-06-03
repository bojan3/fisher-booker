insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Mikronaselje', 'Blok A1');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Heroja Pinkija', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Evrope', '58');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Cara Lazara', '101');
insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Sumica 15', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Banatsko Novo Selo', 'Oslobodjenja', '58');
insert into address (country, city, street, number) values ('Serbia', 'Beograd', 'Cara Dusana', '17-a');
insert into address (country, city, street, number) values ('United Kingdom', 'London', 'Oxford Street', '34');
insert into address (country, city, street, number) values ('Jadran sea', 'Five cave Island', 'Wild Street', '1');
insert into address (country, city, street, number) values ('Serbia', 'Nis', 'Spic Petrol', '1');

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_CLIENT');
insert into role (name) values ('ROLE_INSTRUCTOR');
insert into role (name) values ('ROLE_COTTAGE_OWNER');	
insert into role (name) values ('ROLE_SHIP_OWNER');

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('gale','gale@gmail.com', '$2a$10$H/Ei64SSObBqEIM9q2AZxeeU7xIK9z0lWUKemkn1Q36iwtodZ/pXC', 'Jovan', 'Gaspar', '123456789', 1, TRUE, TRUE, FALSE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('bojan','bojan@gmail.com', '$2a$10$h8VcT2Y42IFQZUdjNRG7leGGw2gXnUZzXRDmvgLOmjzjR29b32jlK', 'Bojan', 'Skokic', '123456789', 2, TRUE, TRUE, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('sasvimprirodno','jovopustolov@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jovan', 'Memedovic', '123456789', 3, TRUE, TRUE, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('mire','miroljub@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Miroljub', 'Petrovic', '123456789', 4, TRUE, TRUE, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('JackSparrow','jacksparrow@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jack', 'Sparrow', '123456789', 6, TRUE, TRUE, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('BearGrylls','beargrills@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Bear', 'Grylls', '123456789', 5, TRUE, TRUE, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('Crnobradi','crnobradi@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Crnobradi', 'Paja', '123456789', 7, TRUE, TRUE, TRUE);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified) values ('Spic','tihomirspic@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Tihomir', 'Stojkovic', '123456789', 8, TRUE, TRUE, TRUE);

insert into account_role (account_id, role_id) values (1,1);
insert into account_role (account_id, role_id) values (2,2);
insert into account_role (account_id, role_id) values (3,3);
insert into account_role (account_id, role_id) values (4,4);
insert into account_role (account_id, role_id) values (5,5);
insert into account_role (account_id, role_id) values (6,3);
insert into account_role (account_id, role_id) values (7,5);
insert into account_role (account_id, role_id) values (8,4);

insert into cottage_owner (account_id) values (4);
insert into cottage_owner (account_id) values (8);

insert into client(account_id) values(2);

insert into fishing_instructor(account_id,biography) values(3,'Jednom recju smeker. Poznat po televizijskom serijalu pod nazivom "Sasvim prirodno" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');
insert into fishing_instructor(account_id,biography) values(6,'Dve reci smeker prejak. Poznat po televizijskom serijalu pod nazivom "Bear Grylls" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');

insert into ship_owner (account_id) values (5);
insert into ship_owner (account_id) values (7);

insert into adventure (account,name,description,capacity,price,cancel_rate, address_id) values (1,'Zbilazak Djerdapske klisure','Ujutru se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2, 7);
insert into adventure (account,name,description,capacity,price,cancel_rate,address_id) values (2,'Zbilazak Djerdapske klisure','Ujutru se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2,7);
insert into adventure (account,name,description,capacity,price,cancel_rate,address_id) values (2,'Spustanje Tarom','Poslepodne se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2,7);
insert into adventure (account,name,description,capacity,price,cancel_rate,address_id) values (2,'Zora na Rtnju','Iz Beograda se krece pre ponoci. Na odrediste stizemo oko pola 4. Odmah nakon dolaska krece se u osvajanje Rtnja. Nakon 2,3 sata borbe sa zimom dolazimo do vrha. Povratak se ocekuje predvece.',20,10,0.2,7);

insert into instructor_subscriptions (client_id, instructor_id) values (1, 1);
insert into instructor_subscriptions (client_id, instructor_id) values (1, 2);

insert into availability_period(start_date, end_date) values('2022-05-31', '2022-06-30');
insert into availability_period(start_date, end_date) values('2022-06-02', '2022-06-12');
insert into availability_period(start_date, end_date) values('2022-06-15', '2022-06-27');
insert into availability_period(start_date, end_date) values('2022-07-02', '2022-08-12');

insert into cottage (description, name, address_id, availability_period_id, price_per_day, average_mark, cottage_owner_id) values ('rezervisi bre', 'Najjaca vikendica', 2, 1,20, 0, 1);
insert into cottage (description, name, address_id, availability_period_id, price_per_day, average_mark, cottage_owner_id) values ('Slike govore vise od reci', 'Villa Mirna', 3, 2,50, 1, 1);
insert into cottage (description, name, address_id, price_per_day, average_mark) values ('Zlatiborske lepote, veoma lep pogled', 'Villa Anja', 4, 50, 2);
insert into cottage (description, name, address_id, price_per_day, average_mark) values ('Visoko u panini, zubori reka u blizini', 'Villa Smilja', 6,70, 3);
insert into cottage (description, name, address_id, price_per_day, average_mark) values ('u kotlini, brza voda tece', 'Villa Tamara', 1, 40, 4);
insert into cottage (description, name, address_id, price_per_day, average_mark) values ('Vikendica skrivena u sumi', 'Villa Zagorka', 5, 30, 5);

insert into room(label, num_of_beds, cottage_id) values('A1', 2, 1);
insert into room(label, num_of_beds, cottage_id) values('A2', 1, 1);
insert into room(label, num_of_beds, cottage_id) values('B1', 2, 2);
insert into room(label, num_of_beds, cottage_id) values('B2', 1, 2);

insert into rule(description) values('Zabranjeno pušenje u vikendici');
insert into rule(description) values('Zabranjeno uništavanje imovine');

insert into cottage_picture(path, cottage_id) values('../../assets/images/cottage1.png', 1);
insert into cottage_picture(path, cottage_id) values('../../assets/images/cottage2.png', 1);

insert into cottage_rules(cottage_id, rules_id) values(1, 1);
insert into cottage_rules(cottage_id, rules_id) values(1, 2);

insert into cottage_option(name, description, price, cottage_id) values('Teniski teren', 'Iznajmljuje se na sat', 400, 1);
insert into cottage_option(name, description, price, cottage_id) values('Masaža', 'Sat vremena', 1000, 1);

insert into cottage_super_deal(start_date, end_date, discounted_price, capacity, cottage_id) values('2021-12-29', '2022-01-03', 12, 4, 1);
insert into cottage_super_deal(start_date, end_date, discounted_price, capacity, cottage_id) values('2022-01-05', '2022-01-10', 10, 4, 1);

insert into ship (name, type, length, description, average_mark, rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate, ship_owner_id, availability_period_id) values ('Jahta Bosanka' , null, 3, 'Jahta za uzivanje', 5, 100, 10, 170, 150, 30, 0, 1, 3);
insert into ship (name, type, length, description, average_mark, rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate, ship_owner_id, availability_period_id) values ('Jahta Jovana' , null, 3, 'Jahta za uzivanje', 3, 150, 20, 200, 100, 40, 0, 1, 4);
insert into ship (name, type, length, description, average_mark, rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate, ship_owner_id) values ('Jahta Katarina' , null, 3, 'Jahta za uzivanje', 7, 100, 30, 300, 150, 10, 0, 2);

insert into ship_picture(path, ship_id) values('../../assets/images/gusar1.png', 1);

insert into ship_reservation(start_date, end_date, ship_id, client_id) values ('2022-05-31', '2022-06-10', 1, 1);

insert into ship_rules(ship_id, rules_id) values(1, 1);
insert into ship_rules(ship_id, rules_id) values(1, 2);

insert into ship_option(name, description, price, ship_id) values('Obilazak akvarijuma', 'Gleda se', 350, 1);
insert into ship_option(name, description, price, ship_id) values('Masaža', 'Sat vremena', 1000, 1);

insert into ship_super_deal(start_date, end_date, discounted_price, capacity, ship_id) values('2021-12-29', '2022-01-03', 12, 4, 1);
insert into ship_super_deal(start_date, end_date, discounted_price, capacity, ship_id) values('2022-01-05', '2022-01-10', 10, 4, 1);
