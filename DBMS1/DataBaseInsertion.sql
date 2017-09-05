/*****INSERT DATA INTO MEMBERS TABLE*****/
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test1','address1','city1','member');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test2','address2','city2','faculty');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test3','address3','city3','member');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test4','address4','city4','member');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test5','address5','city5','faculty');
INSERT INTO members(member_name, address_line1, address_line2, category)  VALUES('test6','address6','city6','faculty');

/*****INSERT DATA INTO PUBLISHERS TABLE*****/
INSERT INTO publishers(publisher_name) VALUES('Tata McGraw');
INSERT INTO publishers(publisher_name) VALUES('Random House');
INSERT INTO publishers(publisher_name) VALUES('Pearson');
INSERT INTO publishers(publisher_name) VALUES('Schaum');
INSERT INTO publishers(publisher_name) VALUES('Readers Digest');

/*****INSERT DATA INTO AUTHORS TABLE*****/
INSERT INTO authors(author_name) VALUES('White');
INSERT INTO authors(author_name) VALUES('Green');
INSERT INTO authors(author_name) VALUES('Black');
INSERT INTO authors(author_name) VALUES('Orange');
INSERT INTO authors(author_name) VALUES('Yellow');

/*****INSERT DATA INTO SUBJECTS TABLE*****/
INSERT INTO subjects(subject_name) VALUES('Thriller');
INSERT INTO subjects(subject_name) VALUES('Action');
INSERT INTO subjects(subject_name) VALUES('Comedy');
INSERT INTO subjects(subject_name) VALUES('Romance');
INSERT INTO subjects(subject_name) VALUES('YA');
INSERT INTO subjects(subject_name) VALUES('Science Fiction');

/*****TITLES TABLE****/
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Harry Potter', 5, 5);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Scherlock', 5, 2);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('The great gatsby', 3, 3);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Digital Fortress', 1, 5);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Jurrasic Park', 1, 5);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Around the world', 3, 2);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('Work.Pray.Eat.', 1, 1);
INSERT INTO titles(title_name, subject_id, publisher_id) VALUES('7 minutes', 2, 1);

/****title_author****/
INSERT INTO title_author(title_id, author_id) VALUES(1,3);
INSERT INTO title_author(title_id, author_id) VALUES(2,3);
INSERT INTO title_author(title_id, author_id) VALUES(3,3);
INSERT INTO title_author(title_id, author_id) VALUES(4,4);
INSERT INTO title_author(title_id, author_id) VALUES(5,5);
INSERT INTO title_author(title_id, author_id) VALUES(6,4);
INSERT INTO title_author(title_id, author_id) VALUES(7,4);
INSERT INTO title_author(title_id, author_id) VALUES(8,4);

/*****BOOKS TABLE*****/
INSERT INTO books(title_id, price, status) VALUES(1, 100.90, true);
INSERT INTO books(title_id, price, status) VALUES(2, 200.50, true);
INSERT INTO books(title_id, price, status) VALUES(3, 500.90, false);
INSERT INTO books(title_id, price, status) VALUES(4, 112.30, true);
INSERT INTO books(title_id, price, status) VALUES(5, 120.40, false);
INSERT INTO books(title_id, price, status) VALUES(6, 90.90, true);
INSERT INTO books(title_id, price, status) VALUES(7, 20.90, true);
INSERT INTO books(title_id, price, status) VALUES(8, 188.37, false);

/****BOOK ISSUE***/
INSERT INTO book_issue(accession_number, member_id) VALUES(1,3);
INSERT INTO book_issue(accession_number, member_id) VALUES(1,3);
INSERT INTO book_issue(accession_number, member_id) VALUES(3,2);
INSERT INTO book_issue(accession_number, member_id) VALUES(4,6);

/*****BOOK RETURN****/
INSERT INTO book_return(accession_number, member_id, issue_date) VALUES(1, 3,'2017-09-04 22:45:57');
INSERT INTO book_return(accession_number, member_id, issue_date) VALUES(4,6, '2017-09-04 22:59:16');