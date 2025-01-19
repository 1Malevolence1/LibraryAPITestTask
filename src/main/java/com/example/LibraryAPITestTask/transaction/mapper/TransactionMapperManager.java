package com.example.LibraryAPITestTask.transaction.mapper;


import com.example.LibraryAPITestTask.transaction.controller.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.Transactional;

public interface TransactionMapperManager {

     Transactional toDto(TransactionBookRequestDto transactionBookRequestDto);
}
