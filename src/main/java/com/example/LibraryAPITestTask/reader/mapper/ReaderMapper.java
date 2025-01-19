package com.example.LibraryAPITestTask.reader.mapper;


import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;
import com.example.LibraryAPITestTask.reader.model.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    @Mapping(target = "id", source = "readerId")
    Reader toDto(Long readerId);

    Reader toEntity(TopReaderResponseDto topReaderResponseDto);

    TopReaderResponseDto toTopReaderResponseDto(Reader reader);
}
