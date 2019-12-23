USE javaweb;

CREATE TABLE administratorlogin(
username VARCHAR(45) NOT NULL,
password varchar(45) NOT NULL,
primary key(username));

CREATE TABLE teacherlogin(
username VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
primary key(username));

CREATE TABLE studentlogin(
username VARCHAR(45) NOT NULL,
password VARCHAR(45) NOT NULL,
primary key(username));

CREATE TABLE department(
dept_name VARCHAR(45) NOT NULL,
primary key(dept_name));

CREATE TABLE course(
course_id VARCHAR(45) NOT NULL,
description VARCHAR(450),
dept_name VARCHAR(45),
primary key(course_id),
foreign key(dept_name) references department(dept_name) on delete set null);

CREATE TABLE instructor(
t_id VARCHAR(45) NOT NULL,
t_rank VARCHAR(45),
intro VARCHAR(45),
dept_name VARCHAR(45),
primary key(t_id),
foreign key(t_id) References teacherlogin(username) on delete cascade,
foreign key(dept_name) References department(dept_name) on delete set null);

CREATE TABLE teaches(
t_id VARCHAR(45) NOT NULL,
course_id VARCHAR(45),
primary key(t_id,course_id),
foreign key(t_id) references instructor(t_id) on delete cascade,
foreign key(course_id) References course(course_id) on delete cascade);

CREATE TABLE message(
title VARCHAR(45) NOT NULL,
s_id VARCHAR(45) NOT NULL,
time DATETIME,
course_id VARCHAR(45),
primary key(title,s_id),
foreign key(s_id) references studentlogin(username) on delete cascade,
foreign key(course_id) references course(course_id) on delete cascade);

CREATE TABLE community(
title VARCHAR(45) NOT NULL,
s_id VARCHAR(45),
s_que VARCHAR(450),
s_pic VARCHAR(45),
s_read VARCHAR(45),
t_id VARCHAR(45),
t_ans VARCHAR(450),
t_pic VARCHAR(45),
t_read VARCHAR(45),
primary key(title,s_id),
foreign key(title) references message(title) ON DELETE CASCADE ON UPDATE CASCADE,
foreign key(s_id) references studentlogin(username) on delete cascade);

CREATE TABLE admit(
t_id VARCHAR(45),
course_id VARCHAR(45),
s_id VARCHAR(45),
primary key(t_id,course_id,s_id),
foreign key(t_id) references instructor(t_id) on delete cascade,
foreign key(course_id) references course(course_id) on delete cascade,
foreign key(s_id) references studentlogin(username) on delete cascade);


