package com.example.LibraryAPITestTask.transaction.service;

import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;
import com.example.LibraryAPITestTask.transaction.controller.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;

import java.util.List;

public interface TransactionService {

    void transaction(TransactionBookRequestDto dto, TypeOperation typeOperation);
    List<Reader> getTopReader();
}
