package com.example.LibraryAPITestTask.transaction.service;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.transaction.controller.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;

import java.util.List;

public interface TransactionService {

    void transaction(TransactionBookRequestDto dto, TypeOperation typeOperation);
    List<ReaderResponseDto> getTopReader();
    List<ReaderResponseDto> getReadersNotReturnBooks();
}
