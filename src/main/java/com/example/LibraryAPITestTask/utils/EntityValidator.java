package com.example.LibraryAPITestTask.utils;

public interface EntityValidator {

    void validate(Long readerId, Long bookId);
    void validate(Long readerId);
}
