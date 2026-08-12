# Civilian Registry Management System

A Java-based application for managing a civilian registry using a MySQL database.

The project provides basic CRUD operations for storing, searching, updating, and removing civilian records while using JDBC for communication between the Java application and the MySQL database.

## Features

* Add new civilians to the registry
* Check if a civilian already exists
* Search for civilian records
* Update existing civilian information
* Remove civilians from the registry
* Input validation
* MySQL database integration
* SQL queries stored in separate `.sql` files
* Transaction handling with commit and rollback

## Technologies Used

* Java
* MySQL
* JDBC
* SQL
* Git / GitHub
* Visual Studio Code

## Project Structure

```text
Civilian-Registry/
│
├── src/
│   ├── SQL_Scripts/
│   │   ├── add_person.sql
│   │   ├── create_tables.sql
│   │   ├── exist_person.sql
│   │   ├── remove_person.sql
│   │   └── update_person.sql
│   │
│   ├── Database.java
│   ├── Database_Manager.java
│   ├── Menu.java
│   └── Person.java
│
├── .gitignore
└── README.md
```

## Main Components

### Person

Represents a civilian and stores information such as identification details and other personal data used by the registry.

### Database_Manager

Handles communication between the Java application and the MySQL database using JDBC.

Its responsibilities include:

* Establishing database connections
* Checking whether the database exists
* Creating the required database/tables
* Executing SQL operations
* Managing transactions
* Handling commit and rollback operations

### Menu

Provides the user interface for interacting with the registry and accessing the available operations.

### SQL Scripts

SQL queries are stored separately from the Java source code to keep the project organized and make database operations easier to maintain.

## Database

The application uses MySQL as its database management system.

The Java application connects to MySQL through JDBC and uses `PreparedStatement` for database operations.

The database and its required tables can be created by the application when necessary.

## Requirements

To run the project you need:

* Java JDK
* MySQL Server
* MySQL Connector/J

## Running the Project

1. Clone the repository.
2. Make sure MySQL Server is installed and running.
3. Add MySQL Connector/J to the project's dependencies.
4. Configure the database connection settings in `Database_Manager.java`.
5. Compile and run the Java application.

## Purpose

This project was developed as part of my practical training in Java and backend development.

Its main purpose is to practice and demonstrate:

* Object-Oriented Programming
* Java database connectivity with JDBC
* SQL and relational databases
* CRUD operations
* Prepared statements
* Transaction management
* Input validation
* Separation of application and database logic

## Future Improvements

* Migration to Maven for dependency management
* RESTful API implementation
* Improved exception handling
* Database configuration through environment variables
* Unit and integration testing

## Author

GEORGIOS NANNOS
