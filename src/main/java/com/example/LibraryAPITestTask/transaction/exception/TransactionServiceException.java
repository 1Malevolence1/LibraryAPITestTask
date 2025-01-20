package com.example.LibraryAPITestTask.transaction.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TransactionServiceException extends RuntimeException {

    private final Validate validate;

    public TransactionServiceException(Validate validate, Throwable cause) {
        super(validate.error(), cause);
        this.validate = validate;
    }
}
