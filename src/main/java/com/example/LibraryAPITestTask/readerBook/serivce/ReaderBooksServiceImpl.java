package com.example.LibraryAPITestTask.readerBook.serivce;


import com.example.LibraryAPITestTask.book.model.Book;
import com.example.LibraryAPITestTask.reader.model.Reader;
import com.example.LibraryAPITestTask.readerBook.ReaderAndBook;
import com.example.LibraryAPITestTask.readerBook.ReaderBookRepository;
import com.example.LibraryAPITestTask.readerBook.ReaderBooksIds;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderBooksServiceImpl implements ReaderBookOperationService {

    private final ReaderBookRepository repository;



    private void create(ReaderAndBook readerAndBook) {
        repository.save(readerAndBook);
    }


    private void delete(ReaderAndBook readerAndBook) {
        repository.delete(readerAndBook);
    }

    @Override
    public ReaderAndBook build(Reader reader, Book book) {
        return new ReaderAndBook(new ReaderBooksIds(
                reader.getId(),
                book.getId()),
                reader,
                book);
    }


    @Override
    public void processReaderBookOperation(TypeOperation typeOperation, ReaderAndBook readerAndBook) {
        if (typeOperation == TypeOperation.TAKE) {
            create(readerAndBook);
        } else if (typeOperation == TypeOperation.RETURN) {
            delete(readerAndBook);
        }
    }

}
