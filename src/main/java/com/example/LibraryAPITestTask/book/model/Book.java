package com.example.LibraryAPITestTask.book.model;


import com.example.LibraryAPITestTask.author.model.Author;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class Book {

    @Id
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name", nullable = false)
    private String name;

    @Column(name = "publicationDate", nullable = false)
    private LocalDate publicationDate;


    @ManyToMany()
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    )
    @ToString.Exclude
    private List<Author> authors;
}
