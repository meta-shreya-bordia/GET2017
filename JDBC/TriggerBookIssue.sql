USE library_information_system;

/*
Trigger function to be called as a sub-routine
after inserting any tuple into the `book_issue`
(update status of book to be not-available)
*/
DELIMITER //
CREATE TRIGGER check_book_return
   AFTER INSERT ON `book_return`
   FOR EACH ROW
   BEGIN
       UPDATE books
       SET status = true
       WHERE books.accession_number = NEW.accession_number;
   END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER check_book_issue
  BEFORE INSERT ON `book_issue`
  FOR EACH ROW
  BEGIN
   IF((SELECT status 
       FROM books  
       WHERE books.accession_number = NEW.accession_number) = false)
   THEN
      SET NEW.accession_number = null;
   ELSE  
      UPDATE books
      SET status = false
      WHERE books.accession_number = NEW.accession_number;
   end IF;
  END //
  DELIMITER ;

/**Example tests*/
INSERT INTO books(title_id, price) VALUES(1, 100.20);
INSERT INTO book_issue(issue_date, member_id, accession_number) VALUES(now(), 8, 1);
INSERT INTO book_return(issue_date, accession_number, member_id, return_date) VALUES('2017-09-05 12:35:04', 5, 2, now());

SELECT * FROM books B
JOIn titles T ON B.title_id = T.title_id
AND title_name = 'Harry Potter'
AND status = 1;

SELECT * FROM books;
SELECT * FROM book_issue;