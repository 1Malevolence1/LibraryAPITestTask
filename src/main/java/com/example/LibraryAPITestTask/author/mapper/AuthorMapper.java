package com.example.LibraryAPITestTask.author.mapper;

import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.author.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuthorMapper {
    Author toEntity(AuthorResponseDto authorResponseDto);

    AuthorResponseDto toAuthorResponseDto(Author author);
}