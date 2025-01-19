package com.example.LibraryAPITestTask.author.dto;

import java.time.LocalDate;

/**
 * DTO for {@link com.example.LibraryAPITestTask.author.model.Author}
 */
public record AuthorResponseDto(Long id, String name, String surname, LocalDate dateOfBirth) {
}