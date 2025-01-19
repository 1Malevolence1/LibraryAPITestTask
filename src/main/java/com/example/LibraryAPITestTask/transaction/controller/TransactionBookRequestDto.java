package com.example.LibraryAPITestTask.transaction.controller;

import com.example.LibraryAPITestTask.transaction.model.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for {@link com.example.LibraryAPITestTask.transaction.model.Transactional}
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionBookRequestDto {

    private Long readerId;
    private Long bookId;
}