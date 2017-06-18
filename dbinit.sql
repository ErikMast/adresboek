CREATE SCHEMA adresboek;

CREATE USER IF NOT EXISTS adresboek IDENTIFIED BY 'adresboek';
GRANT ALL ON adresboek.* TO 'adresboek'@'%';

CREATE TABLE adresboek.persoon
(
  id       NUMERIC(11) PRIMARY KEY,
  voornaam VARCHAR(100) NOT NULL
);

