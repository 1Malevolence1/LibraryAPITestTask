package com.example.LibraryAPITestTask.transaction.mapper;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.Transactional;

public interface TransactionMapperManager {

     Transactional toDto(TransactionBookRequestDto transactionBookRequestDto);
}
