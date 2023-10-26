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
