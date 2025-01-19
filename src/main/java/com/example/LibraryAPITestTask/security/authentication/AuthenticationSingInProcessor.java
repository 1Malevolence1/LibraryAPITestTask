package com.example.LibraryAPITestTask.security.authentication;


import com.example.LibraryAPITestTask.security.jwt.JwtTokenGenerate;
import com.example.LibraryAPITestTask.security.jwt.JwtTokenSingInResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationSingInProcessor {


    private final JwtTokenGenerate jwtTokenGenerate;

    public JwtTokenSingInResponseDto processor(UserDetails userDetails){
        return jwtTokenGenerate.generateToken(userDetails);
    }
}
