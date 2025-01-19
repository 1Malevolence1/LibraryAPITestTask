package com.example.LibraryAPITestTask.reader.mapper;

import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;

import java.util.List;

public interface ReaderMapperManager {

    List<ReaderResponseDto> toDto(List<Reader> model);
}
