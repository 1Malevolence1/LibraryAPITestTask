package com.example.LibraryAPITestTask.employee.repository;

import com.example.LibraryAPITestTask.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<Employee> findByEmail(String email);
}
