package com.example.LibraryAPITestTask.transaction.mapper;

import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.Transactional;
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
