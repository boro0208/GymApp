insert into `users` (`id`,
`address`,
`city`,
`date_created`,
`date_birth`,
`email`,
`gender`,
`loy_card`,
`mobile_phone`,
`name`,
`password`,
`status`,
`surname`,
`user_create`,
`zip`)
values
(1,
'Test',
'Test',
'01.01.2022',
'01.01.2022',
'boro.radojcic@gmail.com',
'MALE',
'01012022',
'060100011',
'Boro',
'$12$PK9jm9P4XFWy/qtrgyAfo.Secx5EIc5z6oDisy0BxGCetHHxGUb/S',--1234
'ACTIVE',
'RADOJCIC',
1,
'23000');

insert into `roles` (`id`, `name`)
values(1, 'ROLE_USER');

insert into `roles` (`id`, `name`)
values(2, 'ROLE_MANAGER');

insert into `roles` (`id`, `name`)
values(3, 'ROLE_ADMIN');

insert into `users_roles`(`user_id`, `roles_id`)
values (1, 3);
