## JPACRUDProject

### Description
This is a web application that allows the user to interact with a database of textbooks, performing Create, Read, Update, and Delete (CRUD) functions. It is backed with a MySQL database running on an Apache Tomcat server. Any changes entered by a user via the Web interface will persist in the database. The user can also view database information in various formats, including a listing of all available records; search by ID; and search by author/title.

### Topics and Technologies Used
* Relational databases
* MySQL
* Database planning/design with MySQL Workbench
* Jakarta Persistence Query Language (JPQL)
* Java Persistence API (JPA)
* Gradle for dependency management
* Model View Controller (MVC) design pattern
* Design Access Object (DAO) design pattern
* Spring Boot
* Java server pages (JSPs)
* Java Standard Tag Library (JSTL)
* Bootstrap and CSS for front-end development
* JUnit

### How to Run
* Run LearningResourceApplication from the package com.skilldistillery.learningresource.

### Lessons Learned
* This project required a very detailed configuration with multiple "moving parts". It was very valuable to examine the stack trace when things were not working. For instance, I realized via the stack trace that I had entered subtly incorrect login credentials for the database, which made the whole application break. It would have taken me a long, long time to find this error without the stack trace telling me about it.
* It is valuable to encapsulate different program functions within different classes: the database accessor object is the only class touching the database directly; the model/view controller controls the user's flow through the application; and the "textbook" entity is encapsulated in a class, making it easy to test with JUnit.
* HTML tables are a useful way to display database information, particularly because it is easy to use Bootstrap to make them look good quickly.