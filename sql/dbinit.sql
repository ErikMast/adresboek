CREATE DATABASE adresboek;
USE adresboek;

CREATE USER IF NOT EXISTS adresboek IDENTIFIED BY 'adresboek';
GRANT ALL ON adresboek.* TO 'adresboek'@'%';

CREATE TABLE persoon
(
  id       INT PRIMARY KEY AUTO_INCREMENT,
  voornaam VARCHAR(100) NOT NULL
);

