/****************************** ASSIGNMENT 2 ****************************/

/*1. display tables in database*/
SHOW TABLES;

/*2. display return date for book_issued*/
SELECT * FROM book_issue;

/*3. drop members table from DB: remove FK constraints*/
SET @@foreign_key_checks = 0;
DROP table library_information_system.members;
SET @@foreign_key_checks = 1;

SHOW TABLES;

/*4. create table when members table does not exist in DB*/
CREATE TABLE IF NOT EXISTS members(
    member_id INT NOT NULL AUTO_INCREMENT,
    member_name CHAR(20) NOT NULL,
    address_line1 VARCHAR(30),
    address_line2 VARCHAR(30),
    category CHAR(20),
    PRIMARY KEY (member_id)
);

SHOW TABLES;

/*5. INSERT DATA INTO MEMBERS TABLE*/
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test1','address1','city1','member');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test2','address2','city2','faculty');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test3','address3','city3','member');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test4','address4','city4','member');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test5','address5','city5','faculty');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test6','address6','city6','faculty');

SELECT * FROM MEMBERS;

/***************ASSIGNMENT 3*****************/

/*1. SCHEMA VIEW*/
SELECT * FROM members;
SELECT * FROM publishers;
SELECT * FROM authors;
SELECT * FROM SUBJECTS;
SELECT * FROM TITLES;
SELECT * FROM books;
SELECT * FROM book_issue;
SELECT * FROM BOOK_RETURN;
SELECT * FROM TITLE_AUTHOR;

/*2. Update address line 2 for each row: UNSAFE UPDATE: turn off safe updates*/
SET SQL_SAFE_UPDATES = 0;
UPDATE members SET address_line2 = 'jaipur';

SELECT * FROM MEMBERS;

/*3. Update address line 1 for each row: WHERE category is faculty*/
UPDATE members SET address_line1 = 'EPIP, Sitapura' WHERE category = 'faculty';

SELECT * FROM MEMBERS;

/*4. Delete all tuples from publishers*/
DELETE FROM publishers;

SELECT * FROM publishers;

/*5. Insert data into publisher with substitution variables*/
ALTER TABLE publishers AUTO_INCREMENT = 1;
SET @publisher_1 = 'Tata McGraw';
INSERT INTO publishers(publisher_name) VALUES(@publisher_1);
SET @publisher_2 = 'Pearson';
INSERT INTO publishers(publisher_name) VALUES(@publisher_2);

SELECT * FROM publishers;

/*6. Delete rows from titles with publisher id as 1*/
ALTER TABLE titles AUTO_INCREMENT = 1;
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Work.Pray.Eat.', 1, 1);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('7 minutes', 2, 1);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Ginger Harry', 2, 2);

SELECT * FROM titles;

DELETE FROM titles WHERE publisher_id = 1;

SELECT * FROM titles;