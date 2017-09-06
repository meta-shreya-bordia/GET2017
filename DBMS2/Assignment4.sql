/**********ASSIGNMENT 4************/
/**
Consider a form where providing a Zip Code populates associated City and State. 
Resultset containing Zip Code, City Names and States ordered by State Name and City Name.
**/
CREATE DATABASE city_zip_codes;

USE city_zip_codes;

CREATE TABLE state(
state_id INT,
state_name CHAR(30),

PRIMARY KEY(state_id)
);

CREATE TABLE city(
zip_code NUMERIC(6,0),
city_name CHAR(20) NOT NULL,
state_id CHAR(30) NOT NULL,

PRIMARY KEY(zip_code)
);

ALTER TABLE city ADD CONSTRAINT `fk_city_state` FOREIGN KEY(state_id) REFERENCES city(state_id);

LOAD DATA LOCAL INFILE 'C:\\Users\\User14\\Downloads\\GET2017-DBMS-DBMS1\\GET2017-DBMS-DBMS1\\DBMS2\\StateList.txt' INTO TABLE state
FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n';

SELECT * FROM state;

LOAD DATA LOCAL INFILE 'C:\\Users\\User14\\Downloads\\GET2017-DBMS-DBMS1\\GET2017-DBMS-DBMS1\\DBMS2\\CityList.txt' INTO TABLE city
FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n';

SELECT * FROM city;

SELECT zip_code, city_name, state_name
FROM city
LEFT JOIN state ON city.state_id = state.state_id
ORDER BY state_name ASC, city_name ASC;