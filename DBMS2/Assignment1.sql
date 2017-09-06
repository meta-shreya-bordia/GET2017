/*******ASSIGNMENT 1********/

/*1. Display ONLY attributes in the members table*/
SHOW COLUMNS FROM library_information_system.members;

/*2. Display specific date from members table*/
SELECT member_name, member_id, category FROM members;

/*3. Search data for specific 'category' field in members table*/
SELECT member_name, member_id, category FROM members WHERE category = 'Faculty';

/*4. Get different values in 'category' field*/
SELECT DISTINCT(category) FROM members;

/*5. reverse print the members on their names*/
SELECT member_name FROM members
ORDER BY member_name DESC;

/*6. Display associated subject name and publisher of book for said title of book */
SELECT title_name, subject_name, publisher_name
FROM titles AS T
LEFT JOIN subjects ON T.subject_id = subjects.subject_id
LEFT JOIN publishers ON T.publisher_id = publishers.publisher_id
ORDER BY T.title_name;

/*7. Count by category type*/
SELECT category, COUNT(category)
FROM members
GROUP BY category;

/*8. Get members of the same category as 'Keshav Sharma' category.*/
INSERT INTO members(member_name, address_line1, address_line2, category) VALUES('Keshav Sharma', 'Metacube', 'Jaipur', 'head');
INSERT INTO members(member_name, address_line1, address_line2, category) VALUES('dummy1', 'test data 1', 'city_x', 'head' );
INSERT INTO members(member_name, address_line1, address_line2, category) VALUES('dummy2', 'test data 2', 'city_y', 'head' );

SELECT m1.member_name
FROM members as m1
WHERE m1.category = ( SELECT category
                      FROM members AS m2
                      WHERE member_name = 'Keshav Sharma'
                        );

/*9. Get book issued details and whether these books have been returned (get return date) or if due (display null)*/
SELECT I.issue_date, I.accession_number, I.member_id, R.return_date
FROM book_issue AS I
LEFT OUTER JOIN book_return AS R ON I.accession_number = R.accession_number AND I.member_id = R.member_id AND I.issue_date = R.issue_date;