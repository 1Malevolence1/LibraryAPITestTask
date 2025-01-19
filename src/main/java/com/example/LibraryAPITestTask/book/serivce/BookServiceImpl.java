package com.example.LibraryAPITestTask.book.serivce;


import com.example.LibraryAPITestTask.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public boolean checkExistsBookById(Long bookId) {
        return bookRepository.existsById(bookId);
    }
}
