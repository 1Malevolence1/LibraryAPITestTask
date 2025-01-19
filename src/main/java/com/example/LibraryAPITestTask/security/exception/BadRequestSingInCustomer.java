package com.example.LibraryAPITestTask.security.exception;

import com.example.LibraryAPITestTask.transaction.exception.Validate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BadRequestSingInCustomer extends RuntimeException {
    private final Validate validate;
}
