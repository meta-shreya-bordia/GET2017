USE library_information_system;

/*1. For books issued for more than 2 months:
		> if not yet returned
		> if return date is longer than 2 months for an issue*/
INSERT INTO book_issue(issue_date, accession_number, member_id) VALUES('2017-05-05 11:59:40', 4, 1);	/*No returns*/
INSERT INTO book_issue(issue_date, accession_number, member_id) VALUES('2017-02-10 11:07:10', 2, 2);
INSERT INTO book_issue(issue_date, accession_number, member_id) VALUES('2017-07-05 12:40:12', 1, 4);	
INSERT INTO book_issue(issue_date, accession_number, member_id) VALUES('2016-01-29 11:11:18', 7, 1);

INSERT INTO book_return(return_date, accession_number, member_id, issue_date) VALUES('2017-08-12 11:59:41', 1, 4, '2017-07-05 12:40:12'); /*Return after 2 months*/
INSERT INTO book_return(return_date, accession_number, member_id, issue_date) VALUES('2017-08-10 10:17:59', 2, 2, '2017-02-10 11:07:10'); /*Return after 2 months*/
INSERT INTO book_return(return_date, accession_number, member_id, issue_date) VALUES('2016-03-29 11:11:18', 7, 1, '2016-01-29 11:11:18'); /*At exact 2 months*/
INSERT INTO book_return(return_date, accession_number, member_id, issue_date) VALUES('2017-11-07 10:00:00', 1, 3, '2017-09-06 22:00:49'); /*At 2 month 1 day*/

SELECT * FROM books;
SELECT * FROM book_issue;
SELECT * FROM book_return;

/*
CREATE a virtual table that stores appropriate due dates for a book
Then, get fields that have pending months greater than 2 months 
*/
CREATE VIEW book_library
AS
SELECT 
    M.member_name,
    BI.member_id,
    T.title_name,
    BI.accession_number,
    BI.issue_date,
    BI.due_date,
    timestampdiff(day,
        BI.issue_date,
        IFNULL(return_date, now()) ) AS PENDING_FOR_DAYS
FROM
    book_issue AS BI
JOIN members AS M ON BI.member_id = M.member_id
JOIN books AS B ON BI.accession_number = B.accession_number
JOIN titles AS T ON B.title_id = T.title_id
LEFT OUTER JOIN book_return AS BR ON
	BI.accession_number = BR.accession_number AND BI.member_id = BR.member_id AND BI.issue_date = BR.issue_date;
 
/*TRUNCATE the difference in days*/
SELECT
	member_name,
    member_id,
    title_name,
    accession_number,
    issue_date,
    due_date,
	TRUNCATE(PENDING_FOR_DAYS/30, 0) AS PENDING_FOR_MONTH
FROM book_library
WHERE PENDING_FOR_DAYS > 60
ORDER BY member_name ASC ,title_name ASC;

/*2. Find the maximum length from data enteries and its length*/
INSERT INTO members(member_name) VALUES('Long name for test');
INSERT INTO members(member_name) VALUES('Long name for test1');
INSERT INTO members(member_name) VALUES('long name for test12');
INSERT INTO members(member_name) VALUES('Long name for tesing');

SELECT     member_name, length(member_name)
FROM 	   members
WHERE      length(member_name) = (SELECT MAX(length(member_name))
									FROM members);
                            
/*3 Get number of books issued so far*/
SELECT COUNT(*) AS NUMBER_OF_BOOKS_ISSUED_SO_FAR
FROM book_issue;

/**************DBMS2: A1, Q7 CATEGORY***************/
select * from members;

delete from members where member_id = 13;
update members set category = null where member_id = 10;

select category, count(*)
from members
group by category;

select category, count(member_id)
from members
group by category;

/*Does not consider the null entry for category as a valid entry*/
select category, count(category)
from members
group by category;
/************************************/