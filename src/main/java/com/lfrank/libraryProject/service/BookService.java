package com.lfrank.libraryProject.service;

import com.lfrank.libraryProject.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService  {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
