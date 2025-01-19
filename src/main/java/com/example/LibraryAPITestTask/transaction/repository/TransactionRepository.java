package com.example.LibraryAPITestTask.transaction.repository;

import com.example.LibraryAPITestTask.transaction.model.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactional, Long> {

}
