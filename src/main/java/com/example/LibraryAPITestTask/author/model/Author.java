package com.example.LibraryAPITestTask.author.model;

import com.example.LibraryAPITestTask.book.model.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {


    @Id
    @Column(name = "author_id")
    private Long id;


    @Column(name = "author_name", nullable = false)
    private String name;

    @Column(name = "author_surname", nullable = false)
    private String surname;

    @Column(name = "author_date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToMany()
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    )
    private List<Book> books;

}