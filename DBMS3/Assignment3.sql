USE library_information_system;

/*1. Display total number of faculty, total number of members and total of others*/
SELECT * FROM members;

SELECT
(SELECT COUNT(member_id) 
    FROM members
    WHERE category = 'faculty') AS TOTAL_FACULTY, 
(SELECT COUNT(member_id)
    FROM members 
    WHERE category = 'member')   AS TOTAL_MEMBERS,
(SELECT COUNT(member_id)
    FROM members 
    WHERE category IS NULL OR (category != 'faculty' AND category != 'member')) AS OTHERS;
/*Fails if another category is added and needs to be calculated*/
/*How to calculate for null category field*/

/*2. Titles issued more than 2 times*/
SELECT * FROM book_issue;
SELECT * FROM books;

SELECT  T.title_id, T.title_name
FROM titles AS T
	INNER JOIN books ON T.title_id = books.title_id
	RIGHT JOIN book_issue AS BI ON books.accession_number = BI.accession_number
GROUP BY BI.accession_number
HAVING COUNT(BI.accession_number)> 2;


/*3. Info about book issued to members of category other than 'faculty'*/
SELECT * FROM members;
SELECT * FROM book_issue;

INSERT INTO book_issue(accession_number, member_id) VALUES(1, 8);
INSERT INTO book_issue(accession_number, member_id) VALUES(2, 11);

SELECT issue_date, member_name, BI.member_id, accession_number, category
FROM book_issue AS BI
JOIN members AS M ON BI.member_id = M.member_id
WHERE M.category IS NULL OR M.category != 'faculty';

/*4. Author details for authors whose at least 1 book has been purchased*/
SELECT * FROM author;
SELECT * FROM title_author;

SELECT *
FROM author
WHERE author_id IN ( SELECT title_author.author_id
                    FROM title_author);
                    
/*CHECK WITH EXISTS*/
SELECT title_author.id
FROM title_author
WHERE EXISTS ( SELECT author.author_id
                FROM author);