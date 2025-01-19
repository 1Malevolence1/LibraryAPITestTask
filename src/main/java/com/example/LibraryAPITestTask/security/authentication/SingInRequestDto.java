package com.example.LibraryAPITestTask.security.authentication;

public record SingInRequestDto(
        String email,
        String password
) {
}
