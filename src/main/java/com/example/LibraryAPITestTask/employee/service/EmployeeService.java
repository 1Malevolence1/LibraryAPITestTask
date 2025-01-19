package com.example.LibraryAPITestTask.employee.service;


import com.example.LibraryAPITestTask.employee.model.Employee;

public interface EmployeeService {

    Employee getUserByEmail(String email);
}
