package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;
import com.example.LibraryAPITestTask.reader.mapper.ReaderMapperManager;
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
    private final ReaderMapperManager readerMapperManager;

    @Override
    public List<TopReaderResponseDto> getReaderTopReader() {
        return readerMapperManager.toDto(
                transactionService.getTopReader()
        );
    }
}
