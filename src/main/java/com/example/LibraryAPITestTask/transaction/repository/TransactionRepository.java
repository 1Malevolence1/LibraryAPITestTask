package com.example.LibraryAPITestTask.transaction.repository;

import com.example.LibraryAPITestTask.reader.model.Reader;
import com.example.LibraryAPITestTask.transaction.model.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactional, Long> {



    @Query(value = """
    SELECT r.*
    FROM reader r
    JOIN (
        SELECT t.reader_id, COUNT(t.book_id) AS books_taken
        FROM transactional t
        WHERE t.transactional_type_operation = 'TAKE'
        GROUP BY t.reader_id
    ) AS reader_books ON r.reader_id = reader_books.reader_id
    WHERE reader_books.books_taken = (
        SELECT MAX(books_taken)
        FROM (
            SELECT COUNT(t2.book_id) AS books_taken
            FROM transactional t2
            WHERE t2.transactional_type_operation = 'TAKE'
            GROUP BY t2.reader_id
        ) AS max_books
    )
    """, nativeQuery = true)
    List<Reader> findByTopReader();
}
