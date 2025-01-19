package com.example.LibraryAPITestTask.transaction.service;

import com.example.LibraryAPITestTask.transaction.controller.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;

public interface TransactionService {

    void transaction(TransactionBookRequestDto dto, TypeOperation typeOperation);
}
