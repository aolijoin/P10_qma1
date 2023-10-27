drop database if exists qma;
create database if not exists qma;
use qma;
create table tb_user
(
    id       int primary key auto_increment,
    name     varchar(50),
    username varchar(50),
    password varchar(50)
);

create table tb_dept
(
    id   int auto_increment
        primary key,
    dept varchar(50) null,
    num  int         null
);



create table tb_doctor
(
    id   int auto_increment
        primary key,
    name varchar(50) null,
    time varchar(50) null,
    did  int         null
);

INSERT INTO qma.tb_doctor (name, time, did) VALUES ('咋回事', '08：30', 1);
INSERT INTO qma.tb_doctor (name, time, did) VALUES ('咋回事1', '08：30', 2);
INSERT INTO qma.tb_doctor (name, time, did) VALUES ('咋回事2', '08：30', 3);
INSERT INTO qma.tb_doctor (name, time, did) VALUES ('咋回事3', '08：30', 1);

INSERT INTO qma.tb_user (name, username, password) VALUES ('zhnagsan', 'zhan', '123');
INSERT INTO qma.tb_user (name, username, password) VALUES ('lisi', 'li', '123');
INSERT INTO qma.tb_user (name, username, password) VALUES ('wangwu', 'wang', '123');
INSERT INTO qma.tb_user (name, username, password) VALUES ('超级管理员', 'admin', '123');

INSERT INTO qma.tb_dept (dept, num) VALUES ('儿科', 50);
INSERT INTO qma.tb_dept (dept, num) VALUES ('内科', 20);
INSERT INTO qma.tb_dept (dept, num) VALUES ('肛肠科', 0);
INSERT INTO qma.tb_dept (dept, num) VALUES ('外科', 2);

