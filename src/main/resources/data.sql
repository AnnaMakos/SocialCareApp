insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_DBA');

insert into users (username, email, password) values ('Ania', 'ania@ania.com', '12345');

insert into users_roles (user_id, roles_id) values(1, 1);
insert into users_roles (user_id, roles_id) values(1, 2);
insert into users_roles (user_id, roles_id) values(1, 3);