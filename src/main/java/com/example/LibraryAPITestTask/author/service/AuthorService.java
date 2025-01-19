package com.example.LibraryAPITestTask.author.service;

import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;

import java.time.LocalDateTime;

public interface AuthorService {
    AuthorResponseDto getTopAuthorBetweenTime(LocalDateTime from, LocalDateTime to);
}
