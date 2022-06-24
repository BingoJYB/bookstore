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

CREATE TABLE t_order (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    create_time datetime NOT NULL,
    price decimal(7, 2) NOT NULL,
    status int DEFAULT 0,
    user_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES t_user(id)
);

CREATE TABLE t_order_item (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(30) NOT NULL,
    count int DEFAULT 0,
    price decimal(7, 2) NOT NULL,
    total_price decimal(7, 2) NOT NULL,
    order_id int NOT NULL,
    FOREIGN KEY (order_id) REFERENCES t_order(id)
);