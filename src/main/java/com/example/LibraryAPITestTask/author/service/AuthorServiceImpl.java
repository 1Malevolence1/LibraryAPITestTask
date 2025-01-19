package com.example.LibraryAPITestTask.author.service;

import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.author.mapper.AuthorMapper;
import com.example.LibraryAPITestTask.author.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDto getTopAuthorBetweenTime(LocalDateTime from, LocalDateTime to) {
        return authorMapper.toAuthorResponseDto(
                authorRepository.findTopAuthor(from, to)

        );
    }

}
