package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.readerBook.ReaderWithNotReturnedBooksDto;

import java.util.List;

public interface AnalyticService {

    List<ReaderResponseDto> getReaderTopReader();

    List<ReaderResponseDto> getReaderNotReturnBook();
}
