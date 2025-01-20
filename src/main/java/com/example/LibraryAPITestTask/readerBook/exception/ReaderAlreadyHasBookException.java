package com.example.LibraryAPITestTask.readerBook.exception;

import com.example.LibraryAPITestTask.transaction.exception.Validate;
import lombok.Getter;



@Getter
public class ReaderAlreadyHasBookException extends RuntimeException {
    private final Validate validate;

    public ReaderAlreadyHasBookException(Validate validate) {
        super(validate.error()); // Передаём сообщение в RuntimeException
        this.validate = validate;
    }
}
