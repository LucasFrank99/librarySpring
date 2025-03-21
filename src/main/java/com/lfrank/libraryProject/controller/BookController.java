package com.lfrank.libraryProject.controller;

import com.lfrank.libraryProject.models.Book;
import com.lfrank.libraryProject.service.BookService;
import org.springframework.util.StringUtils;
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
    @DeleteMapping("/library/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    //Update a book
    @PutMapping("/library/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id,book);
    }

    //Find a book by tittle or list all books by author or gender
    @GetMapping("/library/search")
    public List<Book> findBooks(@RequestParam(required = false) String title,
                                @RequestParam(required = false) String author,
                                @RequestParam(required = false) String gender) {
        return bookService.findByCriteria(title, author, gender);
    }
}
