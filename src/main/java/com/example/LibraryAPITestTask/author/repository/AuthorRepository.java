package com.example.LibraryAPITestTask.author.repository;

import com.example.LibraryAPITestTask.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = """
        SELECT a.*
        FROM author a
        JOIN author_book ab ON a.author_id = ab.author_id
        JOIN book b ON ab.book_id = b.book_id
        JOIN transactional t ON b.book_id = t.book_id
        WHERE t.transactional_type_operation = 'TAKE'
          AND t.date_operation BETWEEN :from AND :to
        GROUP BY a.author_id
        ORDER BY COUNT(t.transactional_id) DESC
        LIMIT 1
        """, nativeQuery = true)
    Author findTopAuthor(@Param("from") LocalDateTime f
            , @Param("to") LocalDateTime to );
}
