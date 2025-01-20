package com.example.LibraryAPITestTask.reader.dto;

import com.example.LibraryAPITestTask.reader.model.GenderType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class ReaderWithBookCount {
    private Long readerId;
    private String readerPhone;
    private String readerName;
    private String readerSurname;
    private GenderType readerGender;
    private LocalDate readerDateOfBirth;
    private Long count;


    public ReaderWithBookCount(
            Long readerId,
            String readerPhone,
            String readerName,
            String readerSurname,
            String readerGender,
            java.sql.Date readerDateOfBirth, // Принимаем java.sql.Date
            Long count) {
        this.readerId = readerId;
        this.readerPhone = readerPhone;
        this.readerName = readerName;
        this.readerSurname = readerSurname;
        this.readerGender = GenderType.valueOf(readerGender);
        this.readerDateOfBirth = readerDateOfBirth.toLocalDate();
        this.count = count;
    }
}
