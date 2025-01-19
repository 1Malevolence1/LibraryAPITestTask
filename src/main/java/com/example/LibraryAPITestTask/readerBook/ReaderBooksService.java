package com.example.LibraryAPITestTask.readerBook;

import com.example.LibraryAPITestTask.book.model.Book;
import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;

import java.util.List;

public interface ReaderBooksService {

    void create(ReaderAndBook readerAndBook);
    void delete(ReaderAndBook readerAndBook);
    ReaderAndBook build(Reader reader, Book book);
    List<ReaderResponseDto> getTopReader();
    List<ReaderResponseDto> getReadersNotReturnBooks();
}
