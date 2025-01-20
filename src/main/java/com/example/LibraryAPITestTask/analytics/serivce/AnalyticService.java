package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.reader.dto.ReaderWithBookCount;

import java.time.LocalDateTime;
import java.util.List;

public interface AnalyticService {

    List<ReaderWithBookCount> getTopReader();

    List<ReaderWithBookCount> getReaderNotReturnBook();

    AuthorResponseDto getTopAuthor(LocalDateTime from, LocalDateTime to);
}
