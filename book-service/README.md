

# Book Service API

This is a backend service for managing books, authors, and related entities. It is built using Java (Spring Boot) and utilizes PostgreSQL as the database. The service exposes RESTful endpoints to allow users to interact with the data.

## Table of Contents
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Docker Setup](#docker-setup)


## Tech Stack
- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL

## Features
- Create, update, and delete books and authors.
- Retrieve a list of all books and authors.
- Search for books by title, author, or genre.
- Detailed error handling with appropriate HTTP status codes.

## Prerequisites
Before running the application, ensure you have the following installed:
- **Java 17** or higher
- **Maven** for building the application
- **PostgreSQL** database setup
- **IDE** like IntelliJ IDEA or Eclipse for Java development

## Installation

1. Clone the repository:    ```bash    git clone https://github.com/gopikacb/Book-service.git

2. Navigate to the project directory:   ```bash   cd book-service   ```  
  
3. Install dependencies and build the project:   ```bash   mvn clean install   ```  
  
4. Set up your PostgreSQL database and update the application.properties file  with the necessary credentials (database URL, username, password).

# Configuration

## Database Configuration

In the `src/main/resources/application.properties` file, configure the PostgreSQL connection:  
```properties  

spring.datasource.url=jdbc:postgresql://postgres:5432/library_books
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:postgres}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:postgres}
spring.datasource.driver-class-name=${SPRING_DATASOURCE_DRIVER_CLASS_NAME:org.postgresql.Driver}
spring.datasource.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.initialization-mode=always
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.connection-test-query=SELECT 1
spring.datasource.hikari.max-lifetime=1200000
```


# Usage

## Running the Application

To run the application locally, execute:  
```bash  
mvn spring-boot:run  
```  
The service will start on `http://localhost:8081`.

# API Endpoints

## Books

- `GET /api/books`: Retrieve all books.  
- `GET /api/books/{id}`: Retrieve a book by ID.  
-  `GET /api/books/{id}/availability`: Retrieve availability of a book ( true or false)  by ID.
- `POST /api/books`: Add a new book.  
- `POST /api/books/{id}/status`: Update noOfBooks based on the status ( "BORROWED" or "AVAILABLE") by ID.  
- `PUT /api/books/{id}`: Update a book by ID.  
- `DELETE /api/books/{id}`: Delete a book by ID.
- `GET /api/books/search`: Search for books by title, author, or genre.

# Docker Setup

 1. **Build the Docker image**:

```bash  
    docker build -t book-service:latest .  
```

