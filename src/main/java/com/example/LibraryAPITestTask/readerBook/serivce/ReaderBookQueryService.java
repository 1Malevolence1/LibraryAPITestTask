package com.example.LibraryAPITestTask.readerBook.serivce;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;

import java.util.List;

public interface ReaderBookQueryService {

    List<ReaderResponseDto> getTopReader();
    List<ReaderResponseDto> getReadersNotReturnBooks();
}
