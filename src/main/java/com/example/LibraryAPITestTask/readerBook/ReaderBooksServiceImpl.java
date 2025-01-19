package com.example.LibraryAPITestTask.readerBook;


import com.example.LibraryAPITestTask.book.model.Book;
import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.mapper.ReaderMapperManager;
import com.example.LibraryAPITestTask.reader.model.Reader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderBooksServiceImpl implements ReaderBooksService {

    private final ReaderBookRepository repository;
    private final ReaderMapperManager readerMapperManager;

    @Override
    public void create(ReaderAndBook readerAndBook) {
        repository.save(readerAndBook);
    }

    @Override
    public void delete(ReaderAndBook readerAndBook) {
        repository.delete(readerAndBook);
    }

    @Override
    public ReaderAndBook build(Reader reader, Book book) {
        return new ReaderAndBook(new ReaderBooksIds(
                reader.getId(),
                book.getId()),
                reader,
                book);
    }

    @Override
    public List<ReaderResponseDto> getTopReader() {
        return readerMapperManager.toDto(repository.findByTopReader());
    }

    @Override
    public List<ReaderResponseDto> getReadersNotReturnBooks() {
        return readerMapperManager.toDto(repository.findAllReadersOrderByNotReturnedBooksDesc());
    }

}
