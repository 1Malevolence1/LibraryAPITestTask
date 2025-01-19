package com.example.LibraryAPITestTask.book.repository;

import com.example.LibraryAPITestTask.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
