package com.example.LibraryAPITestTask.utils;


import com.example.LibraryAPITestTask.book.serivce.BookService;
import com.example.LibraryAPITestTask.reader.serivce.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class EntityValidatorImp implements EntityValidator {

    private final ReaderService readerService;
    private final BookService bookService;

    public void validate(Long readerId, Long bookId){
        checkReader(readerId);
        checkBook(bookId);
    }

    public void validate(Long readerId){
        checkReader(readerId);
    }


    private void checkReader(Long readerId){
        if(!readerService.checkExistsReaderById(readerId)) throw new NoSuchElementException("Not found reader with ID::%d".formatted(readerId));
    }

    private void checkBook(Long bookId){
        if(!bookService.checkExistsBookById(bookId)) throw new NoSuchElementException("Not found book with ID::%d".formatted(bookId));
    }

}
