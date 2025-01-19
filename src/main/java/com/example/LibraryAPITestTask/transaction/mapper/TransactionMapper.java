package com.example.LibraryAPITestTask.transaction.mapper;

import com.example.LibraryAPITestTask.book.mapper.BookMapper;
import com.example.LibraryAPITestTask.reader.mapper.ReaderMapper;
import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookMapper.class, ReaderMapper.class})
public interface TransactionMapper {


    @Mapping(target = "reader", source = "readerId")
    @Mapping(target = "book", source = "bookId")
    @Mapping(target = "typeOperation", source = "typeOperation")
    Transactional toModel(TransactionBookRequestDto dto);
}
