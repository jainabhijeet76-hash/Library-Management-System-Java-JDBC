# 📚 Library Management System

## 📖 Project Overview

The **Library Management System** is a console-based Java application developed using **Core Java, JDBC, and MySQL**. It enables librarians to efficiently manage books, members, book issuing, returns, and overdue tracking.

The project follows a **Layered Architecture (Model → DAO → Service → Menu)** to ensure clean code organization, maintainability, and scalability.

---

## 🚀 Features

### 📚 Book Management

* Add New Books
* Update Book Details
* Delete Books
* View All Books
* Track Available Copies

### 👥 Member Management

* Register New Members
* Update Member Information
* Delete Member Records
* View All Members

### 🔄 Book Issue & Return

* Issue Books to Members
* Return Issued Books
* Record Issue Date
* Record Return Date

### ⏰ Overdue Tracking

* View Currently Issued Books
* Identify Overdue Books
* 14-Day Loan Period Validation

---

## 🛠️ Technologies Used

* Java (Core Java)
* JDBC
* MySQL
* OOP Principles
* Collections Framework
* Exception Handling
* Layered Architecture
* Eclipse IDE

---

## 📂 Project Structure

```text
com.adda.model
│
├── Book
├── Member
└── IssueRecord

com.adda.dao
│
├── BookDAO
├── MemberDAO
└── IssueRecordDAO

com.adda.dao.impl
│
├── BookDAOImpl
├── MemberDAOImpl
└── IssueRecordDAOImpl

com.adda.service
│
├── BookService
├── MemberService
└── IssueRecordService

com.adda.service.impl
│
├── BookServiceImpl
├── MemberServiceImpl
└── IssueRecordServiceImpl

com.adda.utility
│
└── DBConnection

com.adda.exception
│
├── LibraryException
├── BookNotFoundException
└── MemberNotFoundException

com.adda.menu
│
└── LibraryMenu

com.adda.main
│
└── Main
```

---

## 🗄️ Database Schema

### Books Table

| Column           | Data Type    |
| ---------------- | ------------ |
| book_id          | INT          |
| title            | VARCHAR(100) |
| author           | VARCHAR(100) |
| publisher        | VARCHAR(100) |
| copies_total     | INT          |
| copies_available | INT          |

### Members Table

| Column    | Data Type    |
| --------- | ------------ |
| member_id | INT          |
| name      | VARCHAR(100) |
| email     | VARCHAR(100) |
| phone     | VARCHAR(15)  |

### Issue Records Table

| Column      | Data Type |
| ----------- | --------- |
| record_id   | INT       |
| book_id     | INT       |
| member_id   | INT       |
| issue_date  | DATE      |
| return_date | DATE      |

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/jainabhijeet76-hash/LibraryManagementSystem.git
```

### 2️⃣ Create Database

```sql
CREATE DATABASE library_db;
```

### 3️⃣ Import SQL Script

Execute:

```text
mysql/library_db.sql
```

### 4️⃣ Configure Database Connection

Update credentials in:

```java
DBConnection.java
```

```java
private static final String URL =
"jdbc:mysql://localhost:3306/library_db";

private static final String USER = "root";

private static final String PASSWORD = "your_password";
```

### 5️⃣ Run the Application

Run:

```java
Main.java
```

---

## 🖥️ Sample Menu

```text
===== LIBRARY MANAGEMENT SYSTEM =====

1. Add Book
2. View Books
3. Update Book
4. Delete Book
5. Add Member
6. View Members
7. Issue Book
8. Return Book
9. View Issued Books
10. View Overdue Books
11. Exit
```

---

## 🎯 Concepts Demonstrated

* Object-Oriented Programming (OOP)
* Encapsulation
* Abstraction
* Interfaces
* JDBC CRUD Operations
* Collections Framework
* Exception Handling
* MySQL Integration
* Layered Architecture
* Java Date & Time API

---

## 🔮 Future Enhancements

* User Authentication & Authorization
* Fine Calculation System
* Search Books by Title or Author
* Search Members by Name
* File Handling Support
* Admin Dashboard
* Spring Boot Migration
* REST API Development
* Web-Based UI

---

## 👨‍💻 Author

### Abhijeet Jain

Java Backend Developer | Spring Boot Learner

**GitHub:** https://github.com/jainabhijeet76-hash

**LinkedIn:** https://www.linkedin.com/in/abhijeet-jain-dev/

---

⭐ If you found this project useful, feel free to give it a star and connect with me on LinkedIn.
