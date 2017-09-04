CREATE DATABASE library_information_system;

USE library_information_System;

/* =================SCHEMA DESIGN============================= */

/****STRONG ENTITY WITH NO FOREIGN KEYS****/

/*AUTHOR: Writer for any book*/
CREATE TABLE author(
    author_id INT NOT NULL AUTO_INCREMENT,
    author_name CHAR(20) NOT NULL,
    PRIMARY KEY (author_id)
);

/*PUBLISHER: Publisher for any book*/
CREATE TABLE publishers(
    publisher_id INT NOT NULL AUTO_INCREMENT,
    publisher_name CHAR(20) NOT NULL,
    PRIMARY KEY (publisher_id)
);

/*MEMBERS: Issues/Returns books in a library*/
CREATE TABLE members(
    member_id INT NOT NULL AUTO_INCREMENT,
    member_name CHAR(20) NOT NULL,
    address_line1 VARCHAR(30),
    address_line2 VARCHAR(30),
    category CHAR(20),
    PRIMARY KEY (member_id)
);

/*SUBJECTS: Genre of a book*/
CREATE TABLE subjects(
    subject_id INT NOT NULL AUTO_INCREMENT,
    subject_name CHAR(30) NOT NULL,
    PRIMARY KEY (subject_id)
);

/******STRONG ENTITY WITH FOREIGN KEYS*****/
/*TITLES: Book title*/
CREATE TABLE titles(
    title_id INT NOT NULL AUTO_INCREMENT,
    title_name CHAR(30) NOT NULL,
    subject_id INT NOT NULL,
    publisher_id INT NOT NULL,
    PRIMARY KEY (title_id)
);

ALTER TABLE titles ADD CONSTRAINT `fk_lis_titles_subjects` FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE ON UPDATE CASCADE; 
ALTER TABLE titles ADD CONSTRAINT `fk_lis_titles_publishers` FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE ON UPDATE CASCADE; 

/*BOOKS: Books in a library*/
CREATE TABLE books(
    accession_number INT NOT NULL AUTO_INCREMENT,
    title_id INT NOT NULL,
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP (),
    price DECIMAL(5, 2 ),
    status BOOLEAN,
    PRIMARY KEY (accession_number)
);

ALTER TABLE books ADD CONSTRAINT `fk_lis_books` FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE; 

/*****WEAK ENTITY: DEPENDENCIES*****/
/*BOOK ISSUE: books that have been issued*/
CREATE TABLE book_issue(
    issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP (),
    accession_number INT NOT NULL,
    member_id INT NOT NULL,
    due_date TIMESTAMP
);

ALTER TABLE book_issue ADD CONSTRAINT `fk_lis_book_issue_books` FOREIGN KEY(accession_number) REFERENCES books(accession_number) ON DELETE CASCADE ON UPDATE CASCADE; 
ALTER TABLE book_issue ADD CONSTRAINT `fk_lis_book_issue_members` FOREIGN KEY(member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE book_issue ADD PRIMARY KEY(accession_number, member_id, issue_date);

/*BOOK RETURN: books issued and have been returned*/
CREATE TABLE book_return(
    return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    accession_number INT NOT NULL,
    member_id INT NOT NULL,
    issue_date TIMESTAMP
);

ALTER TABLE book_return ADD CONSTRAINT `fk_lis_book_return` FOREIGN KEY(accession_number, member_id, issue_date) REFERENCES book_issue(accession_number, member_id, issue_date) ON DELETE CASCADE ON UPDATE CASCADE;

/*TITLE AUTHOR: Unique combination of author-id and title-of-book-number*/
CREATE TABLE title_author(
    title_id INT NOT NULL,
    author_id INT NOT NULL
);

ALTER TABLE title_author ADD CONSTRAINT `fk_lis_title_author_titles` FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE title_author ADD CONSTRAINT `fk_lis_title_author_authors` FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE; 
ALTER TABLE title_author ADD PRIMARY KEY(title_id, author_id);