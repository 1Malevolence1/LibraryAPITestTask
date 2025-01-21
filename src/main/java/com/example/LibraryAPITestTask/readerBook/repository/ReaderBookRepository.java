package com.example.LibraryAPITestTask.readerBook.repository;

import com.example.LibraryAPITestTask.readerBook.model.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.model.ReaderBooksIds;
import com.example.LibraryAPITestTask.reader.dto.ReaderWithBookCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReaderBookRepository extends JpaRepository<ReaderAndBook, ReaderBooksIds> {

    @Query(value = """
    select
     r.reader_id as id,
      r.reader_phone as phone,
      r.reader_name as name,
      r.reader_surname as surname,
      r.reader_gender as gender,
      r.reader_date_of_birth as dateOfBirth,
      count(rb.book_id) as book_count
      from reader as r
      join reader_books as rb using (reader_id)
      group by r.reader_id
      having count(rb.book_id) = (
          select max(book_count)
          from (
              select count(rb2.book_id) as book_count
              from reader_books as rb2
              group by rb2.reader_id
          ) as max_counts
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