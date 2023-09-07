# Library Management Backend (Spring Boot)

# Introduction
The Library Management Backend is a Spring Boot application that provides RESTful APIs for managing books and authors. It serves as the backend component of the Library Management system.


# Features:

- Authentication: Librarians can securely log in and log out of the application.
- Books Listing: Librarians can view a list of books in the library, including details such as titles,   authors, and availability.
- Add a Book: Librarians can add new books to the library, associating each book with a specific author.
- Edit a Book: Librarians can update book details, such as titles and availability.
- Authors Management: Authors' information is maintained in a separate database, and CRUD operations on  authors are supported through RESTful APIs.
- Database: The application utilizes a relational database (e.g., MySQL, PostgreSQL) to store information about books and authors.
- Security: The backend includes security measures to protect the API endpoints, ensuring that only authorized users can perform certain actions.

## Getting Started

### Prerequisites
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) 8 or higher
- [Maven](https://maven.apache.org/download.cgi) (for building and managing dependencies)
- A database (MySQL) configured and running.

### Installation
1. Clone this repository:
https://github.com/Satakshi09/LMSBackend.git


## Configuration
- Configure the database connection in src/main/resources/application.properties.
- Customize security settings in src/main/java/com/example/security/SecurityConfig.java.
- Additional configuration options can be found in the application's properties files.

## Usage

API Endpoints
The backend provides the following RESTful API endpoints for managing books and authors:

- Authors API:
GET /api/authors: List all authors.
POST /api/authors: Create a new author.
PUT /api/authors/{id}: Update an existing author.
DELETE /api/authors/{id}: Delete an author.

- Books API:
GET /api/books: List all books.
GET /api/books/{id}: Retrieve book by ID.
POST /api/books: Create a new book.
PUT /api/books/{id}: Update an existing book.
DELETE /api/books/{id}: Delete a book.



