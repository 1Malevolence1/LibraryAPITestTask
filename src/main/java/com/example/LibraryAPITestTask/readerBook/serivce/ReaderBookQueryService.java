package com.example.LibraryAPITestTask.readerBook.serivce;

import com.example.LibraryAPITestTask.transaction.controller.ReaderWithBookCount;

import java.util.List;

public interface ReaderBookQueryService {

    List<ReaderWithBookCount> getTopReader();
    List<ReaderWithBookCount> getReadersNotReturnBooks();
}
