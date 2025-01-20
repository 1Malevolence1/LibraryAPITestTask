package com.example.LibraryAPITestTask.readerBook.serivce;


import com.example.LibraryAPITestTask.readerBook.exception.ReaderAlreadyHasBookException;
import com.example.LibraryAPITestTask.readerBook.model.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.repository.ReaderBookRepository;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReaderBookCheckReaderPresenceOfBook {

    private final ReaderBookRepository repository;


    public void check(ReaderAndBook readerAndBook){
        if(repository.existsById(readerAndBook.getId())) {
            log.info("У читатель уже есть данная книга");
            throw new ReaderAlreadyHasBookException(new Validate("У читателя уже есть данная книга"));
        }
    }
}
