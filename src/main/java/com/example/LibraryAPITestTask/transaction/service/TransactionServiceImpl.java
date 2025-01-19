package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.mapper.ReaderMapperManager;
import com.example.LibraryAPITestTask.transaction.controller.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.mapper.TransactionMapperManager;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;
import com.example.LibraryAPITestTask.transaction.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapperManager mapper;
    private final ReaderMapperManager readerMapperManager;

    @Override
    @Transactional
    public void transaction(TransactionBookRequestDto dto, TypeOperation typeOperation) {
        com.example.LibraryAPITestTask.transaction.model.Transactional transactional = mapper.toDto(dto);
        transactional.setTypeOperation(typeOperation);
        transactionRepository.save(transactional);
    }

    @Override
    public List<ReaderResponseDto> getTopReader() {
        return readerMapperManager.toDto(transactionRepository.findByTopReader());
    }

    @Override
    public List<ReaderResponseDto> getReadersNotReturnBooks() {
        return readerMapperManager.toDto(transactionRepository.findAllReaderNotReturnBooks());
    }
}
