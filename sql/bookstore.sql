DROP DATABASE IF EXISTS bookstore;

CREATE DATABASE bookstore;

USE bookstore;

DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_book;

CREATE TABLE t_user (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(30) NOT NULL UNIQUE,
    password varchar(20) NOT NULL,
    email varchar(30)
);

CREATE TABLE t_book (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(30) NOT NULL UNIQUE,
    price decimal(7, 2) NOT NULL,
    author varchar(30) NOT NULL,
    sales int DEFAULT 0,
    stock int DEFAULT 0,
    img_path varchar(100)
);