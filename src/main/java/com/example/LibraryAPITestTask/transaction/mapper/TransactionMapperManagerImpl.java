package com.example.LibraryAPITestTask.transaction.mapper;

import com.example.LibraryAPITestTask.transaction.controller.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.Transactional;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TransactionMapperManagerImpl implements TransactionMapperManager {

    private final TransactionMapper mapper;


    @Override
    public Transactional toDto(TransactionBookRequestDto transactionBookRequestDto) {
        return mapper.toModel(transactionBookRequestDto);
    }
}
