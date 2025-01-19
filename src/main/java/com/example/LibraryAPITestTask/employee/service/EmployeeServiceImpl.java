package com.example.LibraryAPITestTask.employee.service;

import com.example.LibraryAPITestTask.employee.model.Employee;
import com.example.LibraryAPITestTask.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getUserByEmail(String email) {
        return employeeRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Неправильная почта или пароль"));
    }
}
