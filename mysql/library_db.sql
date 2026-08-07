-- =====================================
-- DATABASE CREATION
-- =====================================

CREATE DATABASE IF NOT EXISTS library_db;

USE library_db;

-- =====================================
-- BOOKS TABLE
-- =====================================

CREATE TABLE IF NOT EXISTS books (

    book_id INT PRIMARY KEY,

    title VARCHAR(100) NOT NULL,

    author VARCHAR(100) NOT NULL,

    publisher VARCHAR(100),

    copies_total INT NOT NULL,

    copies_available INT NOT NULL

);

-- =====================================
-- MEMBERS TABLE
-- =====================================

CREATE TABLE IF NOT EXISTS members (

    member_id INT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(100),

    phone VARCHAR(15)

);

-- =====================================
-- ISSUE RECORDS TABLE
-- =====================================

CREATE TABLE IF NOT EXISTS issue_records (

    record_id INT PRIMARY KEY AUTO_INCREMENT,

    book_id INT NOT NULL,

    member_id INT NOT NULL,

    issue_date DATE NOT NULL,

    return_date DATE,

    FOREIGN KEY (book_id)
    REFERENCES books(book_id),

    FOREIGN KEY (member_id)
    REFERENCES members(member_id)

);

-- =====================================
-- SAMPLE BOOK DATA
-- =====================================

INSERT INTO books VALUES
(101,'Java Programming','James Gosling','Oracle',10,10),
(102,'Spring Boot Guide','Rod Johnson','Spring',5,5),
(103,'MySQL Essentials','Michael Widenius','MySQL',8,8);

-- =====================================
-- SAMPLE MEMBER DATA
-- =====================================

INSERT INTO members VALUES
(1,'Nitin Choudhary','nitin@gmail.com','9876543210'),
(2,'Rahul Sharma','rahul@gmail.com','9876543211'),
(3,'Aman Verma','aman@gmail.com','9876543212');

-- =====================================
-- TEST QUERIES
-- =====================================

SELECT * FROM books;

SELECT * FROM members;

SELECT * FROM issue_records;