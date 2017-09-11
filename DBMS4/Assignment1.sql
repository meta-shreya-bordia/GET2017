/***ASSIGNMENT 1**/
USE library_information_system;

/*1.
 Write a SELECT command to display name of those members
who belong to the category as to which member
"Jon Snow" belongs.
*/
INSERT INTO members(member_name, category) VALUES('Jon Snow', 'Student');
INSERT INTO members(member_name, category) VALUES('Sub-ordinate1', 'Student');
INSERT INTO members(member_name, category) VALUES('Sub-ordinate2', 'Student');

SELECT * FROM members;

SELECT member_name, category
FROM members
WHERE category = ( SELECT category
                    FROM members
                    WHERE member_name = 'Jon Snow');
                    
/*2.
Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
*/
SELECT * FROM book_issue;
SELECT * FROM book_return;

SELECT BI.accession_number, issue_date, title_name, member_name, due_date
FROM book_issue AS BI
JOIN books AS B ON BI.accession_number = B.accession_number
JOIN titles AS T ON B.title_id = T.title_id
JOIN members AS M ON BI.member_id = M.member_id
WHERE (BI.issue_date, BI.accession_number, BI.member_id)
    NOT IN( SELECT BR.issue_date, BR.accession_number, BR.member_id
                FROM book_return AS BR);
                    
/*3.
Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
*/
SELECT * FROM book_issue;
SELECT * FROM book_return;

INSERT INTO book_return(return_date, accession_number, member_id, issue_date) VALUES();

SELECT issue_date, title_name, member_name, due_date
FROM book_issue AS BI
JOIN books ON BI.accession_number = books.accession_number
JOIN titles ON titles.title_id = books.title_id
JOIN members ON members.member_id = BI.member_id
WHERE due_date < (SELECT return_date
					FROM book_return AS BR
            WHERE BI.accession_number = BR.accession_number
                AND BI.issue_date = BR.issue_date
                AND BI.member_id = BR.member_id);

/*4.
 Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchased so far.
*/
SELECT title_name, accession_number, price
FROM books AS B
JOIN titles ON titles.title_id = B.title_id
WHERE price = (SELECT max(B2.price)
				FROM BOOKS AS B2);

/*5.
Write a SELECT command to display the second maximum price
of a book.
*/
SELECT * FROM books
ORDER BY price DESC;

SELECT max(price)
FROM books
WHERE price < (SELECT max(B2.price)
				FROM books AS B2);

/***OR***/
SELECT price
FROM books
WHERE price < (SELECT max(price)
				FROM books)
ORDER BY price DESC
LIMIT 1;