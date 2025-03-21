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

    //Create a book
    public Book save(Book book) {return bookRepository.save(book);}
    //Delete a book by id
    public void delete(Long id) {
        if(!bookRepository.existsById(id)){
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
    //List all
    public List<Book> bookList() {
        return bookRepository.findAll();
    }

    //Update a book
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setGender(book.getGender());
        return bookRepository.save(existingBook);
    }

    //Search a book by title, author or gender
    public List<Book> findByCriteria(String title, String author, String gender) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitle(title);
        }
        if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthor(author);
        }
        if (gender != null && !gender.isEmpty()) {
            return bookRepository.findByGender(gender);
        }
        return bookRepository.findAll();
    }
}


