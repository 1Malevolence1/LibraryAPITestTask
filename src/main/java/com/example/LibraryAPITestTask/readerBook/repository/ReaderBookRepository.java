package com.example.LibraryAPITestTask.readerBook.repository;

import com.example.LibraryAPITestTask.readerBook.model.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.model.ReaderBooksIds;
import com.example.LibraryAPITestTask.transaction.controller.ReaderWithBookCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderBookRepository extends JpaRepository<ReaderAndBook, ReaderBooksIds> {

    @Query(value = """
    SELECT 
        r.reader_id AS id, 
        r.reader_phone AS phone, 
        r.reader_name AS name, 
        r.reader_surname AS surname, 
        r.reader_gender AS gender, 
        r.reader_date_of_birth AS dateOfBirth,
        reader_books_count.books_count AS count 
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
    List<ReaderWithBookCount> findByTopReader();



    @Query(value = """
    SELECT 
        r.reader_id, 
        r.reader_phone, 
        r.reader_name, 
        r.reader_surname, 
        r.reader_gender, 
        r.reader_date_of_birth, 
        COUNT(rb.book_id) AS count 
    FROM reader r 
    LEFT JOIN reader_books rb ON r.reader_id = rb.reader_id 
    GROUP BY 
        r.reader_id, 
        r.reader_phone, 
        r.reader_name, 
        r.reader_surname, 
        r.reader_gender, 
        r.reader_date_of_birth 
    ORDER BY count DESC
    """, nativeQuery = true)
    List<ReaderWithBookCount> findAllReadersOrderByNotReturnedBooksDesc();
}