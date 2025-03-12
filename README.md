# libraryProject - Book Management API

This is a RESTful API project built with Spring Boot for managing books in a PostgreSQL database. It allows basic CRUD operations (Create, Read, Update, Delete) and provides advanced search features.

## Features

*   **List all books:** Returns the complete list of registered books.
*   **Create a new book:** Adds a new book to the database.
*   **Update an existing book:** Modifies the details of a registered book.
*   **Delete a book:** Removes a book from the database.
*   **Search for books:** Allows searching by title, author, and genre, supporting:
    *   **Partial Search:** Finds books containing the searched string (e.g., searching for "Harry" returns "Harry Potter").
    *   **Case-Insensitive Search:** Ignores uppercase and lowercase differences (e.g., searching for "harry" returns "Harry").
    *   **Combined Search:** Allows searching by multiple criteria simultaneously.
    *   **Returns all books:** Returns all books if no search parameter is provided.

*   **Error Handling:** Implements error handling with a custom exception `BookNotFoundException` and a global exception handler `GlobalExceptionHandler`.

## Technologies Used

*   **Spring Boot:** Java framework for rapid application development.
*   **Spring Data JPA:** Simplifies data access using JPA.
*   **PostgreSQL:** Relational database.
*   **Maven:** Dependency management tool.
*   **Jackson:** Used to convert objects to JSON and vice versa.
*   **Lombok:** (Optional) Reduces boilerplate code.

## Prerequisites

*   **Java JDK 17+**
*   **Maven**
*   **PostgreSQL** installed and configured.

## Configuration

1.  **Database:**
    *   Create a database in PostgreSQL (e.g., `library_db`).
    *   Configure the credentials in the file `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
    spring.datasource.username=postgres
    spring.datasource.password=1234
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update
    ```

    *   Replace `library_db`, `postgres`, and `1234` with your actual credentials.

2. **Run the application:**
    * Execute the `LibraryProjectApplication` class.

## How to Use

### Endpoints

*   **`GET /library`**
    *   Returns all books.
*   **`POST /library`**
    *   Creates a new book.
    *   **Request Body (JSON):**

    ```json
    {
        "title": "The Lord of the Rings",
        "author": "J.R.R. Tolkien",
        "description": "An epic journey in Middle-earth",
        "gender": "Fantasy"
    }
    ```

*   **`PUT /library/{id}`**
    *   Updates a book.
    *   **Parameters:**
        *   `id`: ID of the book to be updated.
    *   **Request Body (JSON):** (same format as `POST`)

*   **`DELETE /library/{id}`**
    *   Deletes a book.
    *   **Parameters:**
        *   `id`: ID of the book to be deleted.

*   **`GET /library/search`**
    *   Searches for books.
    *   **Optional Parameters:**
        *   `title`: Book title (partial and case-insensitive search).
        *   `author`: Book author (partial and case-insensitive search).
        *   `gender`: Book genre (partial and case-insensitive search).
        *   **No parameters:** Returns all books.
    *   **Examples:**
        *   `/library/search?title=harry`: Searches for books with "harry" in the title.
        *   `/library/search?author=rowling`: Searches for books by "rowling".
        *   `/library/search?gender=fantasy`: Searches for books in the "fantasy" genre.
        *   `/library/search?title=harry&author=rowling`: Searches for books with "harry" in the title and "rowling" as the author.
        *   `/library/search`: Returns all books.

### Testing the API with Postman

1.  Download and install [Postman](https://www.postman.com/downloads/).
2.  Start the Spring Boot application.
3.  Use the endpoints and instructions in the "Endpoints" section to interact with the API.

