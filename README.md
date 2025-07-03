# Task7
#  EmployeeApp

A simple Java Console Application using JDBC to perform **CRUD operations** (Create, Read, Update, Delete) on an `employees` table in a MySQL database.

## Objective

To build a **menu-driven employee management system** that allows:

- Adding new employees  
- Viewing all employee records  
- Updating employee email by ID  
- Deleting employees by ID  

## Tools & Technologies Used

- Java (JDK 17)
- JDBC (Java Database Connectivity)
- MySQL Database
- Eclipse IDE
- MySQL Connector/J (JDBC Driver)

## Key Concepts Used

- `JDBC API` for database connectivity  
- `DriverManager` to establish DB connection  
- `Connection`, `PreparedStatement`, `Statement` to interact with DB  
- `ResultSet` to process result sets  
- `try-with-resources` for safe connection handling  
- `Scanner` for console input  
- `while` loop and `switch-case` for menu  
- Exception handling using `try-catch`

## How to Run

### 1 Create the Database

Open MySQL Workbench or MySQL CLI and execute:

```sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    salary DOUBLE
);
```
### 2 Open Eclipse IDE.
### 3. Create a New Java Project.
### 4. Add a Class named EmployeeApp and write the Java code.
### 5. Download MySQL JDBC Driver
   - https://dev.mysql.com/downloads/connector/j/  
   - Add the .jar file to your project via Build Path > Add External JARs.
     
### 6. Update MySQL credentials in the code:
   ```java
    static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String DB_USER = "root";
    static final String DB_PASS = "Your_password";
   ```
### 7. Run the Program:
   - In Eclipse, right-click on EmployeeApp.java.
   - Select Run As > Java Application*.

 
