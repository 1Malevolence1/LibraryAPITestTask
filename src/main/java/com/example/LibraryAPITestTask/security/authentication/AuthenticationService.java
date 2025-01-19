package com.example.LibraryAPITestTask.security.authentication;


import com.example.LibraryAPITestTask.security.jwt.JwtTokenReceivingThroughRefreshTokenResponseDto;
import com.example.LibraryAPITestTask.security.jwt.JwtTokenSingInResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final AuthenticationFindUserDetails authenticationFindUserDetails;
    private final AuthenticationSingInDateValidator authenticationSingInDateValidator;
    private final AuthenticationSingInProcessor authenticationSingInProcessor;
    private final AuthenticationRefreshTokenProcessor authenticationRefreshTokenProcessor;

    public JwtTokenSingInResponseDto authenticate(SingInRequestDto dto) {
        authenticationSingInDateValidator.validate(dto);
        return authenticationSingInProcessor.processor(
                authenticationFindUserDetails.findUserDetailsByEmail(dto.email())
        );
    }

    public JwtTokenReceivingThroughRefreshTokenResponseDto refreshToken(String token){
       UserDetails userDetails = authenticationFindUserDetails.findUserDetailsByToken(token);
       return authenticationRefreshTokenProcessor.processor(userDetails);

    }
}

