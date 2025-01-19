package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.utils.EntityValidator;
import com.example.LibraryAPITestTask.utils.TypeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionValidator {

    private final EntityValidator entityValidator;
    private final TypeValidator typeValidator;

    public void validateTransaction(TransactionBookRequestDto dto){
        typeValidator.validator(dto.getTypeOperation());
        entityValidator.validate(dto.getReaderId(), dto.getBookId());
    }
}
