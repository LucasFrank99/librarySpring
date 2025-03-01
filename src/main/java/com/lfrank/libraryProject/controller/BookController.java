package com.lfrank.libraryProject.controller;

import com.lfrank.libraryProject.models.Book;
import com.lfrank.libraryProject.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //List all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.bookList();
    }

    //Create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    //Delete a book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }


}
