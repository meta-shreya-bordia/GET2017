/*******ASSIGNMENT 3******/

/**
Manage a list of category of products
and their parent category
**/
CREATE DATABASE category_types;

USE category_types;

/*Describe the category of products*/
CREATE TABLE category(
category_id INT,
category_name VARCHAR(30) NOT NULL,
parent_category INT DEFAULT NULL,

PRIMARY KEY(category_id)
);

/*Parent category is self referenced in the category table*/
ALTER TABLE category ADD CONSTRAINT `fk_category_parent` FOREIGN KEY(parent_category) REFERENCES category(category_id) ON DELETE CASCADE;

/******TOP CATEGORIES*******/
INSERT INTO category(category_id, category_name) VALUES(1, 'Mobiles & Tablets');
INSERT INTO category(category_id, category_name) VALUES(2, 'Computers');
INSERT INTO category(category_id, category_name) VALUES(3, 'Home Appliances');

/******MOBILES AND TABLETS******/
INSERT INTO category(category_id, parent_category, category_name) VALUES(4,  1, 'Mobiles');
INSERT INTO category(category_id, parent_category, category_name) VALUES(15, 4, 'Smart Phones');
INSERT INTO category(category_id, parent_category, category_name) VALUES(16, 4, 'Featured Phones');

INSERT INTO category(category_id, parent_category, category_name) VALUES(5,  1, 'Tablets');
INSERT INTO category(category_id, parent_category, category_name) VALUES(17, 5, '2G');
INSERT INTO category(category_id, parent_category, category_name) VALUES(18, 5, '3G');

INSERT INTO category(category_id, parent_category, category_name) VALUES(6,  1, 'Accessories');
INSERT INTO category(category_id, parent_category, category_name) VALUES(7,  1, 'Cases & Covers');

/*********COMPUTERS*********/
INSERT INTO category(category_id, parent_category, category_name) VALUES(8,  2, 'Desktop');
INSERT INTO category(category_id, parent_category, category_name) VALUES(9,  2, 'Laptop');

/*LAPTOP ACCESSORIES*/
INSERT INTO category(category_id, parent_category, category_name) VALUES(10, 2, 'Laptop Accessories');
INSERT INTO category(category_id, parent_category, category_name) VALUES(19, 6, 'Keyboard');
INSERT INTO category(category_id, parent_category, category_name) VALUES(20, 6, 'Mouse');
INSERT INTO category(category_id, parent_category, category_name) VALUES(21, 6, 'Headphones');

/*PRINTERS*/
INSERT INTO category(category_id, parent_category, category_name) VALUES(11, 2, 'Printers');
INSERT INTO category(category_id, parent_category, category_name) VALUES(22, 6, 'Inkjet');
INSERT INTO category(category_id, parent_category, category_name) VALUES(23, 6, 'Laser');

/*******HOME APPLIANCES*******/
/*TVs*/
INSERT INTO category(category_id, parent_category, category_name) VALUES(12, 3, 'TVs');
INSERT INTO category(category_id, parent_category, category_name) VALUES(24, 12, 'LED');
INSERT INTO category(category_id, parent_category, category_name) VALUES(25, 12, 'LCD');
INSERT INTO category(category_id, parent_category, category_name) VALUES(26, 12, 'Plasma');

INSERT INTO category(category_id, parent_category, category_name) VALUES(13, 3, 'Air Conditioners');

/*Washing Machine*/
INSERT INTO category(category_id, parent_category, category_name) VALUES(14, 3, 'Washing Machines');

INSERT INTO category(category_id, parent_category, category_name) VALUES(27, 14, 'Full Automatic');
INSERT INTO category(category_id, parent_category, category_name) VALUES(29, 27, 'Top Load');
INSERT INTO category(category_id, parent_category, category_name) VALUES(30, 27, 'Front Load');

INSERT INTO category(category_id, parent_category, category_name) VALUES(28, 14, 'Semi Automatic');


/*****QUERY*****/
/*1.
to display all the categories along with Parent category.
Result should be sorted on Parent Category.
If category does not have parent then it should display “Top Category” in its Parent category. 
*/
SELECT CHILD.category_name AS CHILD_CATEGORY, IFNULL(PARENT.category_name, 'TOP CATEGORY') AS PARENT_CATEGORY
FROM category AS CHILD
LEFT JOIN category AS PARENT ON CHILD.parent_category = PARENT.category_id;

/*2. Display list of 'TOP CATEGORY'*/
SELECT CHILD.category_name AS CHILD_CATEGORY, IFNULL(PARENT.category_name, 'TOP CATEGORY') AS PARENT_CATEGORY
FROM category AS CHILD
LEFT JOIN category AS PARENT ON CHILD.parent_category = PARENT.category_id
WHERE PARENT.category_ID IS NULL;