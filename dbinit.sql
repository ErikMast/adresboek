CREATE SCHEMA adresboek;

CREATE TABLE adresboek.persoon
(
  id       NUMERIC(11) PRIMARY KEY,
  voornaam VARCHAR(100) NOT NULL
);

