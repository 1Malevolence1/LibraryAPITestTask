package com.example.LibraryAPITestTask.transaction.controller;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
import com.example.LibraryAPITestTask.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/transaction")
@RequiredArgsConstructor
@Slf4j
public class BookTransactionRestController {

    private final TransactionService transactionService;


    @PostMapping("book")
    public ResponseEntity<Void> transaction(@RequestBody TransactionBookRequestDto dto){
        log.info("start method <<transaction>>. Dto: {}", dto);
        transactionService.transaction(dto);
        log.info("methode complete");
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Validate> handlerNoSuchElementException(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Validate(e.getMessage()));
    }
}
