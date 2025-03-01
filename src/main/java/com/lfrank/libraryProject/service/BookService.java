package com.lfrank.libraryProject.service;

import com.lfrank.libraryProject.models.Book;
import com.lfrank.libraryProject.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService  {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Create a new book
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    //Delete a book by id
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    //List all
    public List<Book> bookList() {
        return bookRepository.findAll();
    }
}
