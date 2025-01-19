package com.example.LibraryAPITestTask.reader.mapper;


import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ReaderMapper.class)
public interface ReaderMapperList {

    List<ReaderResponseDto> toDto(List<Reader> dto);
}
