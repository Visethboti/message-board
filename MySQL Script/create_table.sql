CREATE DATABASE IF NOT EXISTS csci640_lab02_db;

USE csci640_lab02_db;

DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
    personID int NOT NULL AUTO_INCREMENT,
    firstName varchar(255),
    lastName varchar(255),
    message varchar(255),
    primary key (personID)
);