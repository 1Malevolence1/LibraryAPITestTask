package com.example.LibraryAPITestTask.reader.mapper;

import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class ReaderMapperManagerImpl implements ReaderMapperManager {

    private final ReaderMapperList readerMapperList;
    @Override
    public List<TopReaderResponseDto> toDto(List<Reader> model) {
        return readerMapperList.toDto(model);
    }
}
