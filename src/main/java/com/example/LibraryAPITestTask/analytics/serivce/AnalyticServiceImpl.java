package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.readerBook.ReaderBooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class AnalyticServiceImpl implements AnalyticService {

    private final ReaderBooksService readerBooksService;

    @Override
    public List<ReaderResponseDto> getReaderTopReader() {
       return readerBooksService.getTopReader();
    }

    @Override
    public List<ReaderResponseDto> getReaderNotReturnBook() {
        return readerBooksService.getReadersNotReturnBooks();
    }
}
