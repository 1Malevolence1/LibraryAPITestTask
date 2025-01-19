package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class AnalyticServiceImpl implements AnalyticService {

    private final TransactionService transactionService;

    @Override
    public List<ReaderResponseDto> getReaderTopReader() {
       return transactionService.getTopReader();
    }

    @Override
    public List<ReaderResponseDto> getReaderNotReturnBook() {
        return transactionService.getReadersNotReturnBooks();
    }
}
