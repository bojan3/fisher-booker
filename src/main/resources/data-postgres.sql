insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Mikronaselje', 'Blok A1');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Heroja Pinkija', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Evrope', '58');
insert into address (country, city, street, number) values ('Serbia', 'Novi Sad', 'Bulevar Cara Lazara', '101');
insert into address (country, city, street, number) values ('Serbia', 'Kikinda', 'Sumica 15', '22A');
insert into address (country, city, street, number) values ('Serbia', 'Banatsko Novo Selo', 'Oslobodjenja', '58');
insert into address (country, city, street, number) values ('Serbia', 'Beograd', 'Cara Dusana', '17-a');
insert into address (country, city, street, number) values ('United Kingdom', 'London', 'Oxford Street', '34');
insert into address (country, city, street, number) values ('Jadran sea', '  cave Island', 'Wild Street', '1');
insert into address (country, city, street, number) values ('Serbia', 'Nis', 'Spic Petrol', '1');
insert into address (country, city, street, number) values ('Croatia', 'Zadar', 'Komandanta kosmickih snaga', '1');
insert into address (country, city, street, number) values ('Macedonia', 'Prilep', 'Marka kraljevica', '1');



insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_CLIENT');
insert into role (name) values ('ROLE_INSTRUCTOR');
insert into role (name) values ('ROLE_COTTAGE_OWNER');	
insert into role (name) values ('ROLE_SHIP_OWNER');


insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, resetpassworddate, version) values ('gale','gale@gmail.com', '$2a$10$H/Ei64SSObBqEIM9q2AZxeeU7xIK9z0lWUKemkn1Q36iwtodZ/pXC', 'Jovan', 'Gaspar', '123456789', 1, TRUE, TRUE, FALSE, FALSE, '1999-05-31', 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('bojan','bojan99skokic@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Bojan', 'Skokic', '123456789', 2, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('sasvimprirodno','jbutea@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jovan', 'Memedovic', '123456789', 3, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('mire','miroljub@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Miroljub', 'Petrovic', '123456789', 4, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('JackSparrow','jacksparrow@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Jack', 'Sparrow', '123456789', 6, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('BearGrylls','beargrills@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Bear', 'Grylls', '123456789', 5, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('Crnobradi','crnobradi@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Crnobradi', 'Paja', '123456789', 7, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('Spic','jbutea@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Tihomir', 'Stojkovic', '123456789', 8, TRUE, TRUE, TRUE, FALSE, 0);

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('Neverifikovani1','neverifikovani@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'nn', 'nn', '123456789', 10, FALSE, FALSE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('Neverifikovani2','neverifikovani@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'nn', 'nn', '123456789', 10, FALSE, FALSE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('Neverifikovani3','neverifikovani@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'nn', 'nn', '123456789', 10, FALSE, FALSE, TRUE, FALSE, 0);

insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('ЋопавиХХХ','crnobradi@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Ћопави', 'Драгиша', '123456789', 9, TRUE, TRUE, TRUE, FALSE, 0);
insert into account (username, email, password, name, last_name, phone_number, address_id, enabled, admin_verified, email_verified, is_deleted, version) values ('majstor','goran.tatomirov@gmail.com', '$2a$12$UxcSVXUNiSn1i0EGlsTOHOkQZxnvk5Ey8xvql7lgmAWJM2CYyXObK', 'Goran', 'Tatomirov', '123456789', 1, TRUE, TRUE, TRUE, FALSE, 0);


insert into account_role (account_id, role_id) values (1,1);
insert into account_role (account_id, role_id) values (2,2);
insert into account_role (account_id, role_id) values (3,3);
insert into account_role (account_id, role_id) values (4,4);
insert into account_role (account_id, role_id) values (5,5);
insert into account_role (account_id, role_id) values (6,3);
insert into account_role (account_id, role_id) values (8,4);
insert into account_role (account_id, role_id) values (9,1);
insert into account_role (account_id, role_id) values (13,5);

--ULOGE NEVERIFIKOVANIH OD STRANE ADMINA
insert into account_role (account_id, role_id) values (10,3);
insert into account_role (account_id, role_id) values (11,4);
insert into account_role (account_id, role_id) values (12,5);

--STATUS

insert into status(name,points) values(4,1000000);
insert into status(name,points) values(2,14);
insert into status(name,points) values(3,13);
insert into status(name,points) values(4,16);
insert into status(name,points) values(4,20);
insert into status(name,points) values(3,23);
insert into status(name,points) values(4,13);
insert into status(name,points) values(3,13);
insert into status(name,points) values(2,3);
insert into status(name,points) values(2,3);
insert into status(name,points) values(0,0);
insert into status(name,points) values(0,0);
insert into status(name,points) values(0,0);

--ACCOUNT STATUS
insert into account_status(account_id,status_id)values(1,1);
insert into account_status(account_id,status_id)values(2,2);
insert into account_status(account_id,status_id)values(3,3);
insert into account_status(account_id,status_id)values(4,4);
-- pravi problem negde u nekom od ovih dodela statusa
insert into account_status(account_id,status_id)values(5,5);
insert into account_status(account_id,status_id)values(6,6);
insert into account_status(account_id,status_id)values(7,7);
insert into account_status(account_id,status_id)values(8,8);
insert into account_status(account_id,status_id)values(9,9);
insert into account_status(account_id,status_id)values(10,10);
insert into account_status(account_id,status_id)values(11,11);
insert into account_status(account_id,status_id)values(12,12);
insert into account_status(account_id,status_id)values(13,13);




insert into cottage_owner (account_id) values (4);
insert into cottage_owner (account_id) values (8);

insert into client(account_id, penals, version) values(2, 1, 0);

insert into fishing_instructor(account_id,biography) values(3,'Jednom recju smeker. Poznat po televizijskom serijalu pod nazivom "Sasvim prirodno" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');
insert into fishing_instructor(account_id,biography) values(6,'Dve reci smeker prejak. Poznat po televizijskom serijalu pod nazivom "Bear Grylls" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');

insert into ship_owner (account_id) values (5);
insert into ship_owner (account_id) values (7);


insert into instructor_subscriptions (client_id, instructor_id) values (1, 1);
insert into instructor_subscriptions (client_id, instructor_id) values (1, 2);

--insert into fishing_instructor(account_id) values(4);

--insert into adventure (account,name,description,capacity,price,cancel_rate) values (1,'Obilazak Djerdapske klisure','Ujutru se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2);

--insert into fishing_instructor(account_id,biography) values(4,'Jednom recju smeker. Poznat po televizijskom serijalu pod nazivom "Sasvim prirodno" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');

--insert into client(account_id) values(8);
insert into client(account_id, penals) values(9, 1);

--insert into fishing_instructor(account_id,biography) values(4,'Jednom recju smeker. Poznat po televizijskom serijalu pod nazivom "Sasvim prirodno" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');
--insert into fishing_instructor(account_id,biography) values(5,'Jednom recju smeker. Poznat po televizijskom serijalu pod nazivom "Bear Grylls" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');
insert into fishing_instructor(account_id,biography) values(13,'Jednom recju smeker. Poznat po televizijskom serijalu pod nazivom "Bear Grylls" ali i drugim emisijama. Obisao mnoge zemlje i narode i se sada posetio svojoj zemlji i narodu. Iako radi na drugim projektima, slobodno vreme voli da provodi kao deo Fishing-Booker tima. ');

insert into ship_owner (account_id) values (6);
insert into ship_owner (account_id) values (7);

insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (1,'Obilazak Djerdapske klisure','Ujutru se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2,7,false);
insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (1,'Spustanje Tarom','Poslepodne se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2,7,false);
insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (1,'Zora na Rtnju','Iz Beograda se krece pre ponoci. Na odrediste stizemo oko pola 4. Odmah nakon dolaska krece se u osvajanje Rtnja. Nakon 2,3 sata borbe sa zimom dolazimo do vrha. Povratak se ocekuje predvece.',20,10,0.2,7,false);
insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (2,'Obilazak Palickog jezera','Ujutru se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2,7,false);
insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (2,'Pecanje u Ohridskom jezeru','Poslepodne se krece iz Beograda. Vozicemo se camcem Dunavom do Djerdapske klisure. Tamo cemo se zadrzati par sati dok obidjemo znamenita mesta. U povratku cemo svratiti u Vincu. Povratak se ocekuje predvece.',20,10,0.2,7,false);
insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (2,'Obedska bara','Iz Beograda se krece pre ponoci. Na odrediste stizemo oko pola 4. Odmah nakon dolaska krece se u osvajanje Rtnja. Nakon 2,3 sata borbe sa zimom dolazimo do vrha. Povratak se ocekuje predvece.',20,10,0.2,7,false);

insert into adventure (instructor_id,name,description,capacity,price,cancel_rate,address_id, is_deleted) values (3,'Homoljske planine','Iz Beograda se krece pre ponoci. Na odrediste stizemo oko pola 4. Odmah nakon dolaska krece se u osvajanje Rtnja. Nakon 2,3 sata borbe sa zimom dolazimo do vrha. Povratak se ocekuje predvece.',20,10,0.2,7,false);


insert into rule (description) values ('Drzati se grupe!');
insert into rule (description) values ('Poneti kupaci!');
insert into rule (description) values ('Poneti satore!');
insert into rule (description) values ('Postovati satnicu dogadjaja!');

insert into adventure_rule(adventure_id, rule_id) values(1, 3);
insert into adventure_rule(adventure_id, rule_id) values(1, 4);

--insert into adventure_rule (adventure_id, rule_id) values (1,1);
insert into adventure_option(name,description,price) values('Voznja motorima','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);
insert into adventure_option(name,description,price) values('Jahanje konja','Nakon pauze pre povratka nazad, obilazi se proplanak pun divljih konja',10);
insert into adventure_option(name,description,price) values('Planinarenje Vitorogom','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);
insert into adventure_option(name,description,price) values('Spust niz ski stazu','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);
insert into adventure_option(name,description,price) values('Penjanje žičarom','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);
insert into adventure_option(name,description,price) values('Letenje balonom','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);
insert into adventure_option(name,description,price) values('Ronjenje','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);
insert into adventure_option(name,description,price) values('Pecanje','Nakon pauze pre povratka nazad, obilazi se jedna staza na kojoj je moguce provozati motore',10);

--insert into adventure_adventure_option(adventure_id, adventure_option_id) values(1,1);

--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('11-12-2021', 12, 20,  0.2, 20, 1, 1, FALSE);
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('12-12-2021', 12, 20,  0.2, 20, 2, 1, FALSE);
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('13-12-2021', 12, 20,  0.2, 20, 3, 1, FALSE);
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('14-12-2021', 12, 20,  0.2, 20, 4, 1, FALSE);
--
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('11/12/2021', 12, 20,  0.2, 20, 1, 2, FALSE);
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('12/12/2021', 12, 20,  0.2, 20, 2, 2, FALSE);
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('13/12/2021', 12, 20,  0.2, 20, 3, 2, FALSE);
--insert into adventure_reservation(start_date, duration, price, cancel_rate, capacity, adventure_id, client_id, deleted)values('14/12/2021', 12, 20,  0.2, 20, 4, 2, FALSE);


--insert into cottage (description, name, address_id, price_per_day, average_mark) values ('Zlatiborske lepote, veoma lep pogled', 'Villa Anja', 4, 50, 2);
--insert into cottage (description, name, address_id, price_per_day, average_mark) values ('Visoko u panini, zubori reka u blizini', 'Villa Smilja', 6,70, 3);
--insert into cottage (description, name, address_id, availability_period_id, price_per_day, average_mark, cottage_owner_id) values ('u kotlini, brza voda tece', 'Villa Tamara', 1, 40, 4);
--insert into cottage (description, name, address_id, availability_period_id, price_per_day, average_mark, cottage_owner_id) values ('Vikendica skrivena u sumi', 'Villa Zagorka', 5, 30, 5);
insert into availability_period(start_date, end_date) values('2022-08-31', '2022-09-30');
insert into	availability_period(start_date, end_date) values('2022-06-02', '2022-06-12');
insert into availability_period(start_date, end_date) values('2022-06-15', '2022-06-27');
insert into availability_period(start_date, end_date) values('2022-07-02', '2022-08-12');
insert into availability_period(start_date, end_date) values('2022-07-02', '2022-08-12');
insert into availability_period(start_date, end_date) values('2022-07-02', '2022-08-12');


insert into cottage (description, name, address_id, price_per_day, average_mark, availability_period_id, cottage_owner_id, is_deleted) values ('rezervisi bre', 'Najjaca vikendica', 2,20, 0, 1, 1, false);
insert into cottage (description, name, address_id, price_per_day, average_mark, availability_period_id, cottage_owner_id, is_deleted) values ('Slike govore vise od reci', 'Vikendica 1', 3, 50, 1, 2, 1, false);
insert into cottage (description, name, address_id, price_per_day, average_mark, availability_period_id, cottage_owner_id, is_deleted) values ('Zlatiborske lepote, veoma lep pogled', 'Vikendica 2', 4, 50, 2,5,2, false);
insert into cottage (description, name, address_id, price_per_day, average_mark, availability_period_id, cottage_owner_id, is_deleted) values ('Visoko u panini, zubori reka u blizini', 'Vikendica 3', 6,70, 3,6,2, false);
--insert into cottage (description, name, address_id, availability_period_id, price_per_day, average_mark) values ('u kotlini, brza voda tece', 'Villa Tamara', 1, 40, 4);
--insert into cottage (description, name, address_id, availability_period_id, price_per_day, average_mark) values ('Vikendica skrivena u sumi', 'Villa Zagorka', 5, 30, 5);

insert into room(label, num_of_beds, cottage_id) values('A1', 2, 1);
insert into room(label, num_of_beds, cottage_id) values('A2', 1, 1);
insert into room(label, num_of_beds, cottage_id) values('B1', 2, 2);
insert into room(label, num_of_beds, cottage_id) values('B2', 1, 2);

insert into rule(description) values('zabranjeno pušenje u vikendici');
insert into rule(description) values('zabranjeno uništavanje imovine');
insert into rule(description) values('zabranjeno pušenje u unutar kabine');
insert into rule(description) values('zabranjeno skakanje u vodu sa palube');

insert into cottage_picture(path, cottage_id) values('../../assets/images/cottage1.png', 1);
insert into cottage_picture(path, cottage_id) values('../../assets/images/cottage2.png', 1);

insert into cottage_rules(cottage_id, rules_id) values(1, 1);
insert into cottage_rules(cottage_id, rules_id) values(1, 2);

insert into cottage_option(name, description, price, cottage_id) values('Teniski teren', 'Iznajmljuje se na sat', 400, 1);
insert into cottage_option(name, description, price, cottage_id) values('Masaža', 'Sat vremena', 1000, 1);

insert into cottage_super_deal(start_date, end_date, discounted_price, capacity, cottage_id) values('2021-12-29', '2022-01-03', 12, 4, 1);
insert into cottage_super_deal(start_date, end_date, discounted_price, capacity, cottage_id) values('2022-01-05', '2022-01-10', 10, 4, 1);

insert into ship (name, type, length, address_id, description, average_mark, rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate, ship_owner_id, availability_period_id, is_deleted) values ('Jahta 1' , 'jahta', 3, 9, 'Jahta za uzivanje', 5, 100, 10, 170, 150, 30, 0, 1, 6,false);
insert into ship (name, type, length, address_id, description, average_mark, rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate, ship_owner_id, availability_period_id, is_deleted) values ('Ledolomac 1' , 'ledolomac', 3,11, 'Jahta za uzivanje', 3, 150, 20, 200, 100, 40, 0, 1, 4, false);
insert into ship (name, type, length, address_id, description, average_mark, rent_price, engine_number, engine_power, max_speed, capacity, cancel_rate, ship_owner_id, availability_period_id, is_deleted) values ('Jahta 2' , 'jahta', 3,12 ,'Jahta za uzivanje',7, 100, 30, 300, 150, 10, 0, 1, 2, false);

--insert into ship_picture(path, ship_id) values('../../assets/images/gusar1.png', 1);

insert into ship_reservation(start_date, end_date, ship_id, capacity, price, client_id, deleted) values ('2022-05-31', '2022-06-10', 1, 2, 20, 1, FALSE);
insert into ship_reservation(start_date, end_date, ship_id, capacity, price, client_id, deleted) values ('2022-06-25', '2022-06-30', 2, 3, 15, 1, FALSE);
insert into ship_reservation(start_date, end_date, ship_id, capacity, price, client_id, deleted) values ('2022-05-31', '2022-06-10', 3, 4, 40, 1, FALSE);

insert into adventure_reservation(start_date, end_date, adventure_id, capacity, price, client_id, deleted, cancel_rate, duration) values ('2022-09-30', '2022-10-10', 1, 1, 20, 1, FALSE, 0.2, 12);
insert into adventure_reservation(start_date, end_date, adventure_id, capacity, price, client_id, deleted, cancel_rate, duration) values ('2022-10-25', '2022-10-30', 2, 5, 70, 1, FALSE, 0.2, 12);
insert into adventure_reservation(start_date, end_date, adventure_id, capacity, price, client_id, deleted, cancel_rate, duration) values ('2022-05-31', '2022-06-10', 3, 4, 40, 1, FALSE, 0.2, 12);
insert into adventure_reservation(start_date, end_date, adventure_id, capacity, price, client_id, deleted, cancel_rate, duration) values ('2022-05-31', '2022-06-10', 4, 1, 20, 1, FALSE, 0.2, 12);
insert into adventure_reservation(start_date, end_date, adventure_id, capacity, price, client_id, deleted, cancel_rate, duration) values ('2022-06-25', '2022-06-30', 5, 5, 70, 1, FALSE, 0.2, 12);
insert into adventure_reservation(start_date, end_date, adventure_id, capacity, price, client_id, deleted, cancel_rate, duration) values ('2022-05-31', '2022-06-10', 6, 4, 40, 1, FALSE, 0.2, 12);



insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-07-31', '2022-09-15', 1, 2, 25, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-06-25', '2022-06-30', 2, 3, 15, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-05-31', '2022-06-10', 3, 5, 50, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-04-27', '2022-04-30', 1, 2, 25, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-02-09', '2022-02-15', 1, 3, 15, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-07-02', '2022-07-06', 2, 5, 50, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-03-22', '2022-03-26', 2, 2, 25, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-02-25', '2022-02-28', 2, 3, 15, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-05-16', '2022-05-19', 1, 5, 50, 1, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2021-12-20', '2021-12-22', 1, 3, 15, 2, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-09-11', '2022-09-15', 1, 5, 50, 2, FALSE);
insert into cottage_reservation(start_date, end_date, cottage_id, capacity, price, client_id, deleted) values ('2022-08-11', '2022-08-30', 1, 5, 50, 2, FALSE);


insert into ship_rules(ship_id, rules_id) values(1, 3);
insert into ship_rules(ship_id, rules_id) values(1, 4);

insert into ship_option(name, description, price, ship_id) values('Obilazak akvarijuma', 'Gleda se', 350, 1);
insert into ship_option(name, description, price, ship_id) values('Masaža', 'Sat vremena', 1000, 1);

insert into ship_super_deal(start_date, end_date, discounted_price, capacity, ship_id) values('2021-12-29', '2022-01-03', 12, 4, 1);
insert into ship_super_deal(start_date, end_date, discounted_price, capacity, ship_id) values('2022-01-05', '2022-01-10', 10, 4, 1);

insert into navigation_equipment(name, ship_id) values ('GPS', 1);
insert into navigation_equipment(name, ship_id) values ('radar', 1);

insert into fishing_equipment(name, ship_id) values('Štapovi za pecanje', 1);
insert into fishing_equipment(name, ship_id) values('Mamac', 1);

-- insert into review(comment, grade, client_id, id_entity, r_entity, published) values ('Pravi profesionalac. Bilo mi je zadovoljstvo biti deo njegove ekipe. Jedva cekam sledecu avanturu. :D', 5.0, 1,1, 0, true);
-- insert into review(comment, grade, client_id, id_entity, r_entity, published) values ('Nisam naucio mnogo toga na casu tamo. Ali pored toga moram priznati da je duhovit covek i to se ceni.', 3.5, 1,1, 0, true);
 insert into review(review_type, approved, comment, for_owner, grade, client_id, adventure_id, cottage_id, ship_id, version) 
 values ('adventure_review', false,'Bolje da sam poveo nekog iz kafane da me nauci nesto nego ovaj covek. Na greskama se uci. :/', true, 1,1, 1, null,null, 0);

 insert into review(review_type, approved, comment, for_owner, grade, client_id, adventure_id, cottage_id, ship_id, version) 
 values ('ship_review', false,'Ovaj brod je veoma dobar i kvalitetan', true, 5,1, null, null,1, 0); 
 
  insert into review(review_type, approved, comment, for_owner, grade, client_id, adventure_id, cottage_id, ship_id, version) 
 values ('cottage_review', false,'Dobro ocuvana vikendica za ove pare', true, 3,1, null, 1,null, 0);
 
insert into delete_account_request(description, account_id) values ('Dosta mi je svega', 4);
insert into delete_account_request(description, account_id) values ('Ovaj nalog je za testiranje brisanja1', 3);
insert into delete_account_request(description, account_id) values ('Ovaj nalog je za testiranje brisanja2', 3);

insert into global_number(name,valuex, version) values('GLOBAL_INCOME_PRECENTAGE',0.2, 0);
insert into global_number(name,valuex, version) values('TOTAL_INCOME',0, 0);


insert into adventure_reservation_support_data(dtype,reservationdate,system_income, price) values('ADV','2022-01-02',0.12,10);
insert into adventure_reservation_support_data(dtype,reservationdate,system_income, price) values('ADV','2022-02-02',0.134,20);

insert into ship_reservation_support_data(dtype,reservationdate,system_income, price) values('SHP','2022-03-22',0.14,60);
insert into ship_reservation_support_data(dtype,reservationdate,system_income, price) values('SHP','2022-04-22',0.124,70);

insert into cottage_reservation_support_data(dtype,reservationdate,system_income, price) values('CTG','2022-01-22',0.24,100);
insert into cottage_reservation_support_data(dtype,reservationdate,system_income, price) values('CTG','2022-05-22',0.23,80);


--insert into ship_reservation_support_data(dtype,reservationdate,system_income) values('SHP','2022-08-12',0.1234);
--insert into ship_reservation_support_data(dtype,reservationdate,system_income) values('SHP','2022-04-12',0.1234);

insert into cottage_subscriptions(client_id, cottage_id) values (1, 1);
insert into cottage_subscriptions(client_id, cottage_id) values (2, 1);


--insert into shreservation_reservation_supportdata (shreservation_id, suppdata_id2) values (1,1);
--nsert into shreservation_reservation_supportdata (shreservation_id, suppdata_id2) values (2,2);

insert into creservation_reservation_supportdata (creservation_id, suppdata_id3) values (1,1);
insert into creservation_reservation_supportdata (creservation_id, suppdata_id3) values (2,2);

insert into complaint(dtype, answer, answered, text, client_id, cottage_id, instructor_id, ship_id, version) 
values ('CottageComplaint', null, false, 'Ovo je daleko od onoga sto ste naveli u opisu', 1,1,null,null, 0);

insert into complaint(dtype, answer, answered, text, client_id, cottage_id, instructor_id, ship_id, version) 
values ('InstructorComplaint', null, false, 'Ovo je daleko od onoga sto ste naveli u opisu', 1,null,1,null, 0);









