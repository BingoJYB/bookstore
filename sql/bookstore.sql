DROP DATABASE IF EXISTS bookstore;

CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE t_user (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(50) NOT NULL UNIQUE,
    password varchar(30) NOT NULL,
    email varchar(50)
);