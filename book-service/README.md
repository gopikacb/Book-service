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
- [Contributing](#contributing)
- [License](#license)

## Tech Stack
- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **API Documentation**: Swagger (for easy exploration of API endpoints)

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

1. Clone the repository:
   ```bash
   git clone https://github.com/gopikacb/Book-service.git