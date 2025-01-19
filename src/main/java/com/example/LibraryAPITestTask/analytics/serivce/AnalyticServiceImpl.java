package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.author.service.AuthorService;
import com.example.LibraryAPITestTask.readerBook.serivce.ReaderBookQueryService;
import com.example.LibraryAPITestTask.transaction.controller.ReaderWithBookCount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class AnalyticServiceImpl implements AnalyticService {

    private final ReaderBookQueryService readerBooksService;
    private final AuthorService authorService;

    @Override
    public List<ReaderWithBookCount> getTopReader() {
       return readerBooksService.getTopReader();
    }

    @Override
    public List<ReaderWithBookCount> getReaderNotReturnBook() {
        return readerBooksService.getReadersNotReturnBooks();
    }

    @Override
    public AuthorResponseDto getTopAuthor(LocalDateTime from, LocalDateTime to) {
        return authorService.getTopAuthorBetweenTime(from, to);
    }
}
