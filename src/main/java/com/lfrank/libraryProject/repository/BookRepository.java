package com.lfrank.libraryProject.repository;

import com.lfrank.libraryProject.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
