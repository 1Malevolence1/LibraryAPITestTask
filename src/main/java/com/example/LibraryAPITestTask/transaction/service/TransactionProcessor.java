package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.readerBook.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.serivce.ReaderBookOperationService;
import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.mapper.TransactionMapperManager;
import com.example.LibraryAPITestTask.transaction.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionProcessor {

    private final TransactionRepository transactionRepository;
    private final TransactionMapperManager mapper;
    private final ReaderBookOperationService readerBooksService;

    @Transactional
    public void processTransaction(TransactionBookRequestDto dto) {
        com.example.LibraryAPITestTask.transaction.model.Transactional transactional = mapper.toDto(dto);
        ReaderAndBook readerAndBook = readerBooksService.build(transactional.getReader(), transactional.getBook());
        readerBooksService.processReaderBookOperation(dto.getTypeOperation(), readerAndBook);
        transactionRepository.save(transactional);
    }
}
