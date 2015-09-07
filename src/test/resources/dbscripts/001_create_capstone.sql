create table capstone_admin
(
	admin_id	int not null auto_increment,
	username	varchar(20) not null comment 'username',
	password	varchar(20) not null comment 'password',
	description	varchar(20) comment 'description',	
	primary key (admin_id)
);