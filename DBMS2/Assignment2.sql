/**
Get details from the book issue table
if books have been returned,
    display their return date
else
    display null
    
Order the view based on issue date. If timestamp is same
    order by member name
**/

INSERT INTO book_issue(accession_number, member_id) VALUES(5, 3);
INSERT INTO book_issue(accession_number, member_id) VALUES(5, 2);

SELECT I.issue_date, M.member_name, I.accession_number, R.return_date
FROM book_issue AS I
LEFT OUTER JOIN book_return AS R ON I.accession_number = R.accession_number AND I.member_id = R.member_id AND I.issue_date = R.issue_date
LEFT OUTER JOIN members AS M ON I.member_id = M.member_id
ORDER BY I.issue_date ASC, M.member_name ASC;