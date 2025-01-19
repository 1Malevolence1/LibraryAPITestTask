package com.example.LibraryAPITestTask.book.mapper;


import com.example.LibraryAPITestTask.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {


    @Mapping(target = "id", source = "bookId")
    Book toModel(Long bookId);
}
