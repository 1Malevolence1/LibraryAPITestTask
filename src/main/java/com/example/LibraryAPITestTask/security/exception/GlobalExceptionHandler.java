package com.example.LibraryAPITestTask.security.exception;


import com.example.LibraryAPITestTask.transaction.exception.Validate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpiredTokenException.class)
    public ResponseEntity<Validate> handleExpiredTokenException(ExpiredTokenException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getValidate());
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Validate> handleInvalidTokenException(InvalidTokenException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getValidate());
    }
}