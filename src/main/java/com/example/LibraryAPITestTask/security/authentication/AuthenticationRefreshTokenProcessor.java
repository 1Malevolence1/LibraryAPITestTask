package com.example.LibraryAPITestTask.security.authentication;


import com.example.LibraryAPITestTask.security.jwt.JwtService;
import com.example.LibraryAPITestTask.security.jwt.JwtTokenReceivingThroughRefreshTokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationRefreshTokenProcessor {

    private final JwtService jwtService;

    public JwtTokenReceivingThroughRefreshTokenResponseDto processor(UserDetails userDetails){
        return new JwtTokenReceivingThroughRefreshTokenResponseDto(jwtService.generateToken(userDetails));
    }
}
