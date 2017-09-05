/*
Trigger function to be called as a sub-routine
before inserting any tuple into the `book_issue`
(execute only once)
*/
DELIMITER $$
CREATE TRIGGER return_date_15days
BEFORE INSERT ON `book_issue` FOR EACH ROW
BEGIN
  SET NEW.due_date = now() + INTERVAL 15 DAY;
END;
$$
DELIMITER ;