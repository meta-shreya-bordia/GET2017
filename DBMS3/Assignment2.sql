USE library_information_system;

SELECT * FROM books;
SELECT * FROM titles;
select * from subjects;

/*1. Subjectwise info for each book purchased (and count of books in each subject)*/
SELECT subject_name, S.subject_id, COUNT(titles.title_id) AS NUMBER_OF_BOOKS_PURCHASED
FROM subjects AS S
LEFT JOIN titles ON titles.subject_id = S.subject_id
GROUP BY subject_id;

/*2. If book is not returned AND due_date() - issue_date > 60 days*/

/*a) ALTER TABLE book_issue DISABLE ALL TRIGGERS; */
/*b) ALTER TRIGGER return_date_15days DISABLE; */
/*c) DELIMITER $$ DROP TRIGGER IF EXISTS `return_date_15days` $$; */

INSERT INTO book_issue(issue_date, accession_number, member_id, due_date) VALUES('2017-05-05 11:59:40', 1, 2, '2017-08-05 11:59:40'); /*returnable*/
INSERT INTO book_issue(issue_date, accession_number, member_id, due_date) VALUES('2005-12-31 11:59:59', 2, 8, '2006-03-03 20:20:20'); /*Has been returned*/
INSERT INTO book_issue(issue_date, accession_number, member_id, due_date) VALUES('2017-05-12 08:08:08', 2, 6, '2017-07-13 19:19:40'); /*61 days*/

INSERT INTO book_return(issue_date, accession_number, member_id, return_date) VALUES('2005-12-31 11:59:59', 2, 8, '2006-03-08 20:20:20');

SELECT * FROM book_issue;
SELECT * FROM book_return;

SELECT BI.member_id, 
	   BI.accession_number,
       BI.issue_date,
       BI.due_date,
       TRUNCATE( timestampdiff(day, BI.issue_date, BI.due_date)/30, 0) AS RETURNABLE
FROM book_issue AS BI
WHERE timestampdiff(day, BI.issue_date, BI.due_date)>60
		AND (BI.issue_date, BI.accession_number, BI.member_id) 
			NOT IN ( SELECT BR.issue_date, BR.accession_number, BR.member_id
						FROM book_return AS BR);

/*3. Display books whose price is greater than the minimum book price*/
SELECT * FROM books;

SELECT *
FROM books AS B1
WHERE B1.price > (SELECT MIN(B2.price)
                    FROM books AS B2  )
ORDER BY price ASC;