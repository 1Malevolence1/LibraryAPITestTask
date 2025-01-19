package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface AnalyticService {

    List<ReaderResponseDto> getReaderTopReader();

    List<ReaderResponseDto> getReaderNotReturnBook();

    AuthorResponseDto getTopAuthor(LocalDateTime from, LocalDateTime to);
}
