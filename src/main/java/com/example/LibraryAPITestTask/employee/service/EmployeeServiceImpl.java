package com.example.LibraryAPITestTask.employee.service;

import com.example.LibraryAPITestTask.employee.model.Employee;
import com.example.LibraryAPITestTask.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getUserByEmail(String email) {
        return employeeRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Not found employee with email::%s".formatted(email)));
    }
}
