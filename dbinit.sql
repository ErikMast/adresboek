//Database creation
CREATE SCHEMA adresboek;

//Create user and rights
CREATE USER 'adresboek'@'localhost' IDENTIFIED VIA mysql_native_password USING '***';
GRANT USAGE ON *.* TO 'adresboek'@'localhost' REQUIRE NONE WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;GRANT ALL PRIVILEGES ON `adresboek`.* TO 'adresboek'@'localhost';

//create persoon table
CREATE TABLE adresboek.persoon
(
  id       NUMERIC(11) PRIMARY KEY,
  voornaam VARCHAR(100) NOT NULL
);

