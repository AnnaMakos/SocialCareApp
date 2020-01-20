create trigger visits_maker
after update on users
for each row
begin

declare hour int;
declare day int;

	set hour = 8;
	set day = 0;

	while day <= 30 do
		while hour <= 10 do

			insert into visit (visit_date, taken, official_id)
			    values (
			    date_add(current_date(), interval concat(day, ",", hour) day_hour),
			    0,
			    new.id
			    );

			set hour = hour + 1;
		end while;
		set hour = 8;
		set day = day + 1;
	end while;

end^;

insert into roles (name) values ('ROLE_USER')^;
insert into roles (name) values ('ROLE_ADMIN')^;
insert into roles (name) values ('ROLE_OFFICIAL')^;

insert into institution (name, address, geox, geoy) values('Pomagamy w centrum', 'al.Jerozolimskie 162, 02-236 Warszawa', 52.207661, 20.944515)^;
insert into institution (name, address, geox, geoy) values('Pomoc dla potrzebujacych', 'Kresowa 1, 05-082 Stare Babice', 52.247963, 20.845952)^;

insert into users (name, surname, username, pesel, street, street_number, local_number, postcode, city, email, password)
values ('Anna', 'Makos', 'anja', '12312312312', 'Warska', '10', '3a', '05-110', 'Warszawa', 'anja.scdb@gcom.pl', '$2a$10$xbLlPEGMZ4h/bH08TNmnB.zn.XhcrboLHiAkpr4NF83fsM3fPOtKu')^;

insert into users (name, surname, username, pesel, street, street_number, postcode, city, email, password)
values ('Kamil', 'Wojciechowski', 'kamil', '12312309800', 'Lekowa', '220', '06-120', 'Zalezie', 'konradbozyscdb@com.pl', '$2a$10$dNuurHYoHJv/YcT4zDBSm.hc.WEXMXB6g75jLTm6qS6Eca8/XrQtO')^;

insert into users (name, surname, username, pesel, street, street_number, postcode, city, email, password)
values ('Karolina', 'Malinowska', 'karola123', '09212312312', 'Wiejska', '10', '05-321', 'Wierzbno', 'pointa96@gmail.com', '$2a$10$5yXJrEx9zkyxBvBS7UlOmuQFSAQ.r41IMEYerec2PUO4JHbl40khG')^;

insert into users_roles (user_id, roles_id) values (1, 1)^;
insert into users_roles (user_id, roles_id) values (1, 2)^;
insert into users_roles (user_id, roles_id) values (2, 1)^;
insert into users_roles (user_id, roles_id) values (3, 1)^;

insert into application (name, path) values ("500+", "https://socialcareannamakos.s3.amazonaws.com/1.txt")^;
insert into application (name, path) values ("300+", "https://socialcareannamakos.s3.amazonaws.com/2.txt")^;
insert into application (name, path) values ("Wniosek o dofinansowanie", "https://socialcareannamakos.s3.amazonaws.com/3.txt")^;