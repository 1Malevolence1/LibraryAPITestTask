package com.example.LibraryAPITestTask.security.jwt;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenGenerate {

    private final JwtService jwtService;

    public JwtTokenSingInResponseDto generateToken(UserDetails userDetails){
        return new JwtTokenSingInResponseDto(
                jwtService.generateToken(userDetails),
                jwtService.generateRefreshToken(userDetails)
        );
    }
}
