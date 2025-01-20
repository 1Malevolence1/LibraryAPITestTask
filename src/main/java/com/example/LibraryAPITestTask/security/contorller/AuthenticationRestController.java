package com.example.LibraryAPITestTask.security.contorller;


import com.example.LibraryAPITestTask.security.authentication.AuthenticationService;
import com.example.LibraryAPITestTask.security.authentication.SingInRequestDto;
import com.example.LibraryAPITestTask.security.jwt.JwtTokenReceivingThroughRefreshTokenResponseDto;
import com.example.LibraryAPITestTask.security.jwt.JwtTokenSingInResponseDto;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Authentication API", description = "API для аутентификации и управления токенами")
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthenticationService authenticationService;

    @Operation(
            summary = "Аутентификация пользователя",
            description = "Метод для аутентификации пользователя и получения JWT токенов (access и refresh)"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Аутентификация прошла успешно", content = @Content(schema = @Schema(implementation = JwtTokenSingInResponseDto.class))),
            @ApiResponse(responseCode = "403", description = "Неверное имя пользователя или пароль", content = @Content(schema = @Schema(implementation = Validate.class)))
    })
    @PostMapping("/singIn")
    public ResponseEntity<JwtTokenSingInResponseDto> singIn(@RequestBody SingInRequestDto dto) {
        return ResponseEntity.ok(authenticationService.authenticate(dto));
    }

    @Operation(
            summary = "Обновление access токена",
            description = "Метод для обновления access токена с использованием refresh токена"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Токен успешно обновлен", content = @Content(schema = @Schema(implementation = JwtTokenReceivingThroughRefreshTokenResponseDto.class))),
            @ApiResponse(responseCode = "403", description = "Недействительный refresh токен", content = @Content(schema = @Schema(implementation = Validate.class))
            )
    })
    @PutMapping("/refresh")
    public ResponseEntity<JwtTokenReceivingThroughRefreshTokenResponseDto> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
