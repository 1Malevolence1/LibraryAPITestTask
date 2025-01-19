package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionProcessor transactionProcessor;
    private final TransactionValidator transactionValidator;


    @Override
    @Transactional
    public void transaction(TransactionBookRequestDto dto) {
        log.info("Проецесс транзакции для readerId: {} and bookId: {}", dto.getReaderId(), dto.getBookId());
        transactionValidator.validateTransaction(dto);
        transactionProcessor.processTransaction(dto);
        log.info("Транзакция прошла успешно");
    }
}

