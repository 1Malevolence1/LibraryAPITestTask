package com.example.LibraryAPITestTask.readerBook.serivce;

import com.example.LibraryAPITestTask.readerBook.repository.ReaderBookRepository;
import com.example.LibraryAPITestTask.transaction.controller.ReaderWithBookCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class ReaderBookQueryServiceImpl implements ReaderBookQueryService {


    private final ReaderBookRepository repository;
    @Override
    public List<ReaderWithBookCount> getTopReader() {
        return (repository.findByTopReader());
    }

    @Override
    public List<ReaderWithBookCount> getReadersNotReturnBooks() {
        return repository.findAllReadersOrderByNotReturnedBooksDesc();
    }

}
