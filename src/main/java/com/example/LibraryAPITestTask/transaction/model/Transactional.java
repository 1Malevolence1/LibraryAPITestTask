package com.example.LibraryAPITestTask.transaction.model;



import com.example.LibraryAPITestTask.book.model.Book;
import com.example.LibraryAPITestTask.reader.model.Reader;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transactional", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Transactional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactional_id")
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "transactional_type_operation", nullable = false)
    private TypeOperation typeOperation;

    @Column(name = "date_operation", nullable = false)
    @CreationTimestamp
    private LocalDateTime dateOperation;


    @ManyToOne()
    @JoinColumn(name = "reader_id")
    private  Reader reader;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

}
