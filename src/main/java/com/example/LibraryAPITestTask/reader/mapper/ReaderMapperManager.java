package com.example.LibraryAPITestTask.reader.mapper;

import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;

import java.util.List;

public interface ReaderMapperManager {

    List<TopReaderResponseDto> toDto(List<Reader> model);
}
