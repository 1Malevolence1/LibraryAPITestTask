package com.example.LibraryAPITestTask.readerBook.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderBooksIds implements Serializable {

    @Column(name = "reader_id")
    private Long readerId;

    @Column(name = "book_id")
    private Long bookId;


}
