insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_OFFICIAL');
insert into roles (name) values ('ROLE_APPLICANT');


insert into institution (name, address, geox, geoy) values('Pomagamy w centrum', 'al.Jerozolimskie 162, 02-236 Warszawa', 52.207661, 20.944515);
insert into institution (name, address, geox, geoy) values('Pomoc dla potrzebujących', 'Kresowa 1, 05-082 Stare Babice', 52.247963, 20.845952);

insert into users (name, surname, username, pesel, street, street_number, local_number, postcode, city, email, password)
values ('Anna', 'Makos', 'anja', '1231231231', 'Warska', '10', '3a', '05-110', 'Warszawa', 'aniamadra@omg.pl', '$2a$10$xbLlPEGMZ4h/bH08TNmnB.zn.XhcrboLHiAkpr4NF83fsM3fPOtKu');

insert into users (name, surname, username, pesel, street, street_number, postcode, city, email, password)
values ('Konrad', 'Zagajnik', 'kondar', '1231230980', 'Lekowa', '220', '06-120', 'Zalezie', 'konradbozy@com.pl', '$2a$10$dNuurHYoHJv/YcT4zDBSm.hc.WEXMXB6g75jLTm6qS6Eca8/XrQtO');


insert into users_roles (user_id, roles_id) values (1, 1);
insert into users_roles (user_id, roles_id) values (1, 2);
insert into users_roles (user_id, roles_id) values (2, 1);