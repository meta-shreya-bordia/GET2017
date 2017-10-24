create database get_testdb;
CREATE USER 'get_user'@'localhost' IDENTIFIED BY 'get_pwd';
GRANT ALL ON get_testdb.* TO 'get_user'@'localhost';

use get_testdb;

create TABLE User (
  id INT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(25),
  lastname VARCHAR(25),
  type VARCHAR(10),
  active BOOLEAN
);