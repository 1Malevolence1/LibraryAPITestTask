package com.example.LibraryAPITestTask.security.jwt;


import com.example.LibraryAPITestTask.security.exception.ExpiredTokenException;
import com.example.LibraryAPITestTask.employee.service.EmployeeService;
import com.example.LibraryAPITestTask.security.exception.InvalidTokenException;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtValidateToken {

    private final JwtService jwtService;
    private final EmployeeService employeeService;

    public UserDetails validateToken(String token) {
        try {
            String email = jwtService.extractUsername(token);
            if (jwtService.isTokenExpired(token)) {
                throw new ExpiredTokenException(new Validate("Срок действия токена истек"));
            }
            return employeeService.getUserByEmail(email);
        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException(new Validate("Срок действия токена истек"));
        } catch (MalformedJwtException e) {
            throw new InvalidTokenException(new Validate("Токен недействителен"));
        } catch (IllegalArgumentException e) {
            throw new InvalidTokenException(new Validate("Токен отсутствует или пуст"));
        }
    }
}
