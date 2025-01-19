package com.example.LibraryAPITestTask.readerBook;


import com.example.LibraryAPITestTask.book.model.Book;
import com.example.LibraryAPITestTask.reader.model.Reader;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reader_books", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ReaderAndBook {

    @EmbeddedId
    private ReaderBooksIds id;

    @ManyToOne
    @MapsId("readerId")
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

}
