package com.example.LibraryAPITestTask.analytics.dto;

import com.example.LibraryAPITestTask.reader.model.GenderType;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.LibraryAPITestTask.reader.model.Reader}
 */
public record TopReaderResponseDto(Long id, String phone, String name, String surname, GenderType gender,
                                   LocalDate dateOfBirth) {
}