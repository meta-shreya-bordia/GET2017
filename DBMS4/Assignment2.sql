USE library_information_system;

/*1.
Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/
SELECT * FROM book_issue;
SELECT * FROM members;

CREATE VIEW member_issue_details
AS
SELECT M.member_id, M.member_name, BI.issue_date, BI.accession_number, BI.due_date
FROM members AS M
LEFT JOIN book_issue AS BI ON BI.member_id = M.member_id;

SELECT *
FROM member_issue_details
ORDER BY member_id;

/*2.
Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O.
*/
SELECT * FROM members;

INSERT INTO members(member_name) VALUES('another_member');

CREATE VIEW member_details
AS
SELECT member_id, member_name, IF(category = 'F', 'FACULTY', IF(category = 'S', 'STUDENT', IFNULL(category, 'OTHERS')) ) AS member_category
FROM members;

SELECT * FROM member_details;

/*3.
Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.
*/
SELECT * FROM book_issue;
SELECT * FROM book_return;
SELECT * FROM titles;

CREATE VIEW book_issue_details
AS
SELECT subject_name, title_name, member_name, category, BI.issue_date, due_date, IFNULL(return_date, 'NULL') AS book_return_date
FROM book_issue AS BI
JOIN books AS B ON BI.accession_number = B.accession_number
JOIN titles AS T ON B.title_id = T.title_id
JOIN subjects ON subjects.subject_id = T.subject_id
JOIN members AS M ON BI.member_id = M.member_id
JOIN book_return AS BR ON BI.accession_number = BR.accession_number 
					AND BI.member_id = BR.member_id 
                    AND BI.issue_date = BR.issue_date;
                    
SELECT * FROM book_issue_details;