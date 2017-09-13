USE library_information_system;

SELECT * FROM title_author;
SELECT * FROM author;
SELECT * FROM titles;

/*1
	 * Fetch all the books published by author, given the name of the author. 
	 * Return the books data (List of Titles).
	 **(return list of valid author books for authors by same name)**

*/
SELECT T.title_id, title_name
FROM titles T, title_author TA, author A
WHERE author_name = 'Black'
    AND A.author_id = TA.author_id
    AND TA.title_id = T.title_id;

SELECT title_id, title_name, subject_id, publisher_id
FROM titles
WHERE title_id =
(SELECT TA.title_id
FROM title_author AS TA
WHERE TA.author_id =
(SELECT A.author_id
FROM author AS A
WHERE author_name = 'Black'));

SELECT T.title_id, title_name, subject_id, publisher_id
FROM titles T, title_author TA
WHERE T.title_id = TA.title_id
AND TA.author_id =
(SELECT A.author_id
FROM author AS A
WHERE A.author_name = 'Black');

/*2 check status of availablity
(create trigger for each book issue and each book return)
	 * Given the name of the book, to be issued by an existing member.
	 * Return flag to indicate whether the  the book has been issued or not.

*/
SELECT * FROM titles;

SELECT *
FROM book_issue BI
WHERE (accession_number, member_id, issue_date)
IN (SELECT BR.accession_number, BR.member_id, BR.issue_date
        FROM book_return BR);

SELECT * FROM book_issue;
SELECT * FROM book_return;

SELECT status
FROM books
WHERE title_id = (SELECT T.title_id
                    FROM titles T
                    WHERE title_name = 'Harry Potter');
                    
SELECT * FROM members WHERE member_id = -80;    

SELECT accession_number 
FROM books 
WHERE status = 1
AND title_id =
(SELECT T.title_id
FROM titles T
WHERE title_name = 'Around the world');

/*3
	 * Delete all those books which were not issued in last 1 year. 
	 * Return the number of books deleted.
*/
SELECT * FROM books;
SELECT * FROM book_issue;

SELECT *
FROM books
WHERE accession_number NOT IN
(SELECT BI.accession_number
FROM book_issue AS BI
WHERE timestampdiff(YEAR, BI.issue_date, NOW()) < 1);