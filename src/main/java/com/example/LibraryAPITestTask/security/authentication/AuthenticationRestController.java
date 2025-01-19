package com.example.LibraryAPITestTask.security.authentication;


import com.example.LibraryAPITestTask.security.jwt.JwtTokenReceivingThroughRefreshTokenResponseDto;
import com.example.LibraryAPITestTask.security.jwt.JwtTokenSingInResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/singIn")
    public ResponseEntity<JwtTokenSingInResponseDto> singIn(@RequestBody SingInRequestDto dto){
        return ResponseEntity.ok(authenticationService.authenticate(dto));
    }


    @PutMapping("/refresh")
    public ResponseEntity<JwtTokenReceivingThroughRefreshTokenResponseDto> refreshToken(@RequestParam("refreshToken") String refreshToken){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
