package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.exception.TransactionServiceException;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
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
        try {
            log.info("Процесс транзакции для readerId: {} и bookId: {}", dto.getReaderId(), dto.getBookId());
            transactionValidator.validateTransaction(dto);
            transactionProcessor.processTransaction(dto);
            log.info("Транзакция прошла успешно");
        } catch (RuntimeException e) {
            log.error("Ошибка при выполнении транзакции для readerId: {} и bookId: {}", dto.getReaderId(), dto.getBookId(), e);
            throw new TransactionServiceException(new Validate("Ошибка при выполнении транзакции: %s ".formatted(e.getMessage())), e);
        } catch (Exception e) {
            log.error("Непредвиденная ошибка при выполнении транзакции для readerId: {} и bookId: {}", dto.getReaderId(), dto.getBookId(), e);
            throw new TransactionServiceException(new Validate("Непредвиденная ошибка при выполнении транзакции: %s".formatted(e.getMessage())), e);
        }
    }
}

