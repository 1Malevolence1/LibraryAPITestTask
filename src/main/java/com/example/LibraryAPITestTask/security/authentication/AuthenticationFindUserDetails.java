package com.example.LibraryAPITestTask.security.authentication;


import com.example.LibraryAPITestTask.employee.service.EmployeeService;
import com.example.LibraryAPITestTask.security.jwt.JwtService;
import com.example.LibraryAPITestTask.security.jwt.JwtValidateToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFindUserDetails {


    private final JwtValidateToken jwtValidateToken;
    private final EmployeeService employeeService;
    private final JwtService jwtService;

    public UserDetails findUserDetailsByEmail(String email){
        return findUserDetails(email);
    }

    public UserDetails findUserDetailsByToken(String token){
        jwtValidateToken.validateToken(token);
        String email = jwtService.extractUsername(token);
        return findUserDetails(email);
    }

    private UserDetails findUserDetails(String email){
        return employeeService.getUserByEmail(email);
    }

}
