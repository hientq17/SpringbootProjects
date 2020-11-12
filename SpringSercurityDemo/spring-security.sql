Create database springsecurity;
use springsecurity;

CREATE TABLE `user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `email` varchar(255) NOT NULL,
 `password` varchar(60) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
 `user_id` int(11) NOT NULL,
 `role_id` int(11) NOT NULL,
 PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Alter table `user_role` add foreign key(user_id) references `user`(id),
						add foreign key(role_id) references `role`(id);
insert into `user` values (1,'hien@gmail.com','12345'),(2,'quang@gmail.com','12345');
insert into `role` values(1,'ROLE_ADMIN'),(2,'ROLE_USER');
insert into `user_role` values(1,1),(2,2);