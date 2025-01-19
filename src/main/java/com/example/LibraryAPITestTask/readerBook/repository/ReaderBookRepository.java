package com.example.LibraryAPITestTask.readerBook.repository;

import com.example.LibraryAPITestTask.reader.model.Reader;
import com.example.LibraryAPITestTask.readerBook.model.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.model.ReaderBooksIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderBookRepository extends JpaRepository<ReaderAndBook, ReaderBooksIds> {

    @Query(value = """
            SELECT r.*
              FROM reader r
              JOIN (
                  SELECT rb.reader_id, COUNT(rb.book_id) AS books_count
                  FROM reader_books rb
                  GROUP BY rb.reader_id
              ) AS reader_books_count ON r.reader_id = reader_books_count.reader_id
              WHERE reader_books_count.books_count = (
                  SELECT MAX(books_count)
                  FROM (
                      SELECT COUNT(rb2.book_id) AS books_count
                      FROM reader_books rb2
                      GROUP BY rb2.reader_id
                  ) AS max_books
              );
    """, nativeQuery = true)
    List<Reader> findByTopReader();


    @Query(value = "SELECT r.*, COUNT(rb.book_id) AS count FROM reader r LEFT JOIN reader_books rb ON r.reader_id = rb.reader_id GROUP BY r.reader_id ORDER BY count DESC", nativeQuery = true)
    List<Reader> findAllReadersOrderByNotReturnedBooksDesc();
}