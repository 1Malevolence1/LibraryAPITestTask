package com.example.LibraryAPITestTask.reader.serivce;

import com.example.LibraryAPITestTask.reader.model.Reader;

import java.util.Optional;

public interface ReaderService {

    boolean checkExistsReaderById(Long readerId);
}
