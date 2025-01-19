package com.example.LibraryAPITestTask.security.exception;

import com.example.LibraryAPITestTask.transaction.exception.Validate;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ExpiredTokenException extends RuntimeException {
    private final Validate validate;
}
