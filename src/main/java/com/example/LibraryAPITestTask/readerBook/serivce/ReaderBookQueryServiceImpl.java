package com.example.LibraryAPITestTask.readerBook.serivce;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.mapper.ReaderMapperManager;
import com.example.LibraryAPITestTask.readerBook.repository.ReaderBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class ReaderBookQueryServiceImpl implements ReaderBookQueryService {


    private final ReaderMapperManager readerMapperManager;
    private final ReaderBookRepository repository;
    @Override
    public List<ReaderResponseDto> getTopReader() {
        return readerMapperManager.toDto(repository.findByTopReader());
    }

    @Override
    public List<ReaderResponseDto> getReadersNotReturnBooks() {
        return readerMapperManager.toDto(repository.findAllReadersOrderByNotReturnedBooksDesc());
    }

}
