create database hibernate;

CREATE TABLE CUSTOMER
(
    CID INTEGER NOT NULL PRIMARY KEY, 
    USERNAME VARCHAR(12) NOT NULL, 
    PASSWORD VARCHAR(12) 
);