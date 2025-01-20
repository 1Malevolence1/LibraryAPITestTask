package com.example.LibraryAPITestTask.transaction.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionTransaction {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Validate> handlerNoSuchElementException(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Validate(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Validate> handlerIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Validate(e.getMessage()));
    }

    @ExceptionHandler(TransactionServiceException.class)
    public ResponseEntity<Validate> handlerTransactionServiceException(TransactionServiceException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getValidate());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Validate> handlerMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Validate(e.getMessage()));
    }

}
