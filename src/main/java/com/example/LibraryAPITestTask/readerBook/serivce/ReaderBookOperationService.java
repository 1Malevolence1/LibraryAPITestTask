package com.example.LibraryAPITestTask.readerBook.serivce;

import com.example.LibraryAPITestTask.book.model.Book;
import com.example.LibraryAPITestTask.reader.model.Reader;
import com.example.LibraryAPITestTask.readerBook.ReaderAndBook;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;

public interface ReaderBookOperationService {


    ReaderAndBook build(Reader reader, Book book);
    void processReaderBookOperation(TypeOperation typeOperation, ReaderAndBook readerAndBook);
}
