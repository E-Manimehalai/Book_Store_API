## Bookstore API

A simple Spring Boot application that provides a RESTful API to manage books and authors.

## Objective

Build a backend API to:
- Create, Read, Update, Delete (CRUD) Books and Authors
- Support filtering, pagination, and sorting
- Document endpoints using Swagger
- Use Postman for API testing

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Swagger (Springfox or Springdoc)
- Postman (for testing)
- 
## Project Structure
book_store/
├── src/
│ └── main/
│ ├── java/
│ │ └── com.example.bookstore/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ ├── service/
│ │ └── BookstoreApplication.java
│ └── resources/
│ ├── application.properties
├── README.md
├── pom.xml

## Features

- CRUD APIs for Book and Author entities
- JPA-based database access
- H2 in-memory database with console access
- Postman collection for testing
- Swagger UI documentation
- Filtering, Pagination & Sorting on Book endpoints

