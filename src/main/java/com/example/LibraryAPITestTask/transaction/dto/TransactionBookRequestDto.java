package com.example.LibraryAPITestTask.transaction.dto;

import lombok.*;

/**
 * DTO for {@link com.example.LibraryAPITestTask.transaction.model.Transactional}
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransactionBookRequestDto {

    private Long readerId;
    private Long bookId;
}