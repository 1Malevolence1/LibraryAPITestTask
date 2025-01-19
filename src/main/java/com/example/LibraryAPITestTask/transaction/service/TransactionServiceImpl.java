package com.example.LibraryAPITestTask.transaction.service;


import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.mapper.ReaderMapperManager;
import com.example.LibraryAPITestTask.readerBook.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.ReaderBooksService;
import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
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

    private final ReaderBooksService readerBooksService;

    @Override
    @Transactional
    public void transaction(TransactionBookRequestDto dto, TypeOperation typeOperation) {
        com.example.LibraryAPITestTask.transaction.model.Transactional transactional = mapper.toDto(dto);
        transactional.setTypeOperation(typeOperation);
        ReaderAndBook readerAndBook = readerBooksService.build(transactional.getReader(), transactional.getBook());
        processReaderBookOperation(typeOperation, readerAndBook);
        transactionRepository.save(transactional);
    }


    private void processReaderBookOperation(TypeOperation typeOperation, ReaderAndBook readerAndBook){
        if (typeOperation == TypeOperation.TAKE) {
            readerBooksService.create(readerAndBook);
        } else if (typeOperation == TypeOperation.RETURN) {
            readerBooksService.delete(readerAndBook);
        }

    }
}
