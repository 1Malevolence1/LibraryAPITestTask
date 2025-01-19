package com.example.LibraryAPITestTask.reader.repository;

import com.example.LibraryAPITestTask.reader.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
