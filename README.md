# Student Management System using Java JDBC and MySQL

## Project Description
This project is a console-based Student Management System developed using Java, JDBC, and MySQL. It connects a Java application with a MySQL database and performs CRUD (Create, Read, Update, Delete) operations.

## Features
- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Delete Student

## Technologies Used
- Java
- JDBC
- MySQL
- VS Code

## Database Setup

Create the database and table in MySQL:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(100),
    marks DOUBLE
);

## How to Run

1. Open the project folder in VS Code.

2. Make sure the following files are present:
   - DBConnection.java
   - Student.java
   - StudentDAO.java
   - Main.java
   - mysql-connector-j-9.5.0 folder

3. Open terminal in VS Code.

4. Compile all Java files using:

```bash
javac -cp ".;mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar" *.java

5. Run the project using:
Bash
java -cp ".;mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar" Main
After running, the following menu will appear:
Plain text
===== Student Management System =====
1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
Enter any option number to perform the required operation.

