package com.example.LibraryAPITestTask.security.jwt;

public record JwtTokenSingInResponseDto(
        String accessesToken,
        String refreshToken
) {
}
