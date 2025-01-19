package com.example.LibraryAPITestTask.reader.mapper;


import com.example.LibraryAPITestTask.reader.model.Reader;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    @Mapping(target = "id", source = "readerId")
    Reader toDto(Long readerId);
}
