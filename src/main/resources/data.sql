insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_OFFICIAL');
insert into roles (name) values ('ROLE_APPLICANT');


insert into institution (name, address, geox, geoy) values('socjal', 'marywilska 170 zalesie', 12.12, 130.130);
insert into institution (name, address, geox, geoy) values('druga instytucyja', 'krolewska 14 05-210 Kraków', 100.20, 45.12);

insert into users (name, surname, username, pesel, street, street_number, local_number, postcode, city, email, password)
values ('Anna', 'Makos', 'anja', '1231231231', 'Warska', '10', '3a', '05-110', 'Warszawa', 'aniamadra@omg.pl', '$2a$10$xbLlPEGMZ4h/bH08TNmnB.zn.XhcrboLHiAkpr4NF83fsM3fPOtKu');

insert into users (name, surname, username, pesel, street, street_number, postcode, city, email, password)
values ('Konrad', 'Zagajnik', 'kondar', '1231230980', 'Lekowa', '220', '06-120', 'Zalezie', 'konradbozy@com.pl', '$2a$10$dNuurHYoHJv/YcT4zDBSm.hc.WEXMXB6g75jLTm6qS6Eca8/XrQtO');


insert into users_roles (user_id, roles_id) values (1, 1);
insert into users_roles (user_id, roles_id) values (1, 2);
insert into users_roles (user_id, roles_id) values (2, 1);