Library Management System
Overview
The Library Management System is a Java-based console application that helps manage library operations
efficiently. The project uses Java, JDBC, and MySQL to store and manage book records. It follows Object
Oriented Programming (OOP) principles and provides a menu-driven interface for performing various
library management tasks.
Features
Book Management
• 
• 
• 
• 
• 
Add new books
View all books
Search books by ID
Update book details
Delete books
Library Operations
• 
• 
• 
Issue books to users
Return issued books
Track issued book status
Database Integration
• 
• 
• 
MySQL database connectivity using JDBC
Persistent storage of book records
SQL-based CRUD operations
User Interface
• 
• 
• 
Menu-driven console application
Interactive user input using Scanner
Easy-to-use command-line interface
Technologies Used
• 
• 
• 
• 
• 
Java
JDBC (Java Database Connectivity)
MySQL
MySQL Connector/J
VS Code

Project Structure
Library-Management-System
│
├── src
│   ├── dao
│   │   └── BookDAO.java
│   │
│   ├── model
│   │   ├── Book.java
│   │   ├── User.java
│   │   └── Transaction.java
│   │
│   ├── service
│   │   └── Library.java
│   │
│   ├── util
│   │   ├── DBConnection.java
│   │   └── DataManager.java
│   │
│   └── LibraryApp.java
│
├── LIB
│   └── mysql-connector-j-9.7.0.jar
│
└── README.md
Database Schema
Books Table
CREATE TABLE books (
id INT PRIMARY KEY,
title VARCHAR(255),
author VARCHAR(255),
issued BOOLEAN DEFAULT FALSE,
issued_to VARCHAR(100),
issue_date DATE
);

Setup Instructions
1. Clone Repository
git clone <repository-url>
cd Library-Management-System
2. Configure MySQL
Create a database:
CREATE DATABASE library_db;
USE library_db;
Create the books table using the schema provided above.
3. Configure Database Connection
Update the database credentials in 
DBConnection.java :
private static final String URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
4. Add MySQL Connector
Download MySQL Connector/J and place the JAR file inside the 
5. Compile
LIB folder.
javac-cp "LIB/mysql-connector-j-9.7.0.jar;src"-d src src/LibraryApp.java
6. Run
java-cp "LIB/mysql-connector-j-9.7.0.jar;src" LibraryApp

Learning Outcomes
Through this project, the following concepts were implemented and practiced:
• 
• 
• 
• 
• 
• 
• 
• 
Object-Oriented Programming (OOP)
JDBC Database Connectivity
SQL CRUD Operations
Exception Handling
Collections and Data Management
Layered Architecture (DAO, Model, Utility)
MySQL Database Design
Console-Based Application Development
Future Enhancements
• 
• 
• 
• 
• 
• 
• 
User Management Module
Authentication System
Fine Calculation for Late Returns
Transaction History Tracking
Dashboard and Analytics
GUI using JavaFX or Swing
REST API Integration
Author
M. Sravan Varma
B.Tech Computer Science (AI & ML)
LinkedIn: https://www.linkedin.com/in/m-sravan-varma/
License
This project is developed for educational and learning purposes.
