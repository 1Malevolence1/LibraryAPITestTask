package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.utils.EntityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionValidator {

    private final EntityValidator entityValidator;

    public void validateTransaction(TransactionBookRequestDto dto){
        entityValidator.validate(dto.getReaderId(), dto.getBookId());
    }
}
