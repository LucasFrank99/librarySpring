package com.lfrank.libraryProject.controller;

import com.lfrank.libraryProject.service.BookService;

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
}
