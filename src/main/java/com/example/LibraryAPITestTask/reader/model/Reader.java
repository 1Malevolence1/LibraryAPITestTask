package com.example.LibraryAPITestTask.reader.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reader", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Reader {

    @Id
    @Column(name = "reader_id")
    private Long id;


    @Column(name = "reader_phone", nullable = false)
    private String phone;


    @Column(name = "reader_name", nullable = false)
    private String name;

    @Column(name = "reader_surname", nullable = false)
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "reader_gender", nullable = false)
    private GenderType gender;


    @Column(name = "reader_date_of_birth")
    private LocalDate dateOfBirth;

}
