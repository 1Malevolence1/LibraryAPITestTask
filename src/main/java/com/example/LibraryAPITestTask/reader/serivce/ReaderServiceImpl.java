package com.example.LibraryAPITestTask.reader.serivce;

import com.example.LibraryAPITestTask.reader.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderServiceImpl implements ReaderService {

    private final ReaderRepository repository;

    @Override
    public boolean checkExistsReaderById(Long readerId) {
        return repository.existsById(readerId);
    }
}
