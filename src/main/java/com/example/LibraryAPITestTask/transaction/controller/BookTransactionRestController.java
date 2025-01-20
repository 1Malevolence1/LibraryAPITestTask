package com.example.LibraryAPITestTask.transaction.controller;


import com.example.LibraryAPITestTask.readerBook.exception.ReaderAlreadyHasBookException;
import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
import com.example.LibraryAPITestTask.transaction.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Transaction API", description = "API для управления транзакциями книг")
@RestController
@RequestMapping("api/transaction")
@RequiredArgsConstructor
@Slf4j
public class BookTransactionRestController {

    private final TransactionService transactionService;


    @Operation(summary = "Метод который осуществит транзакцию с книгой")
    @SecurityRequirement(name = "JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Транзакция успешно выполнена", content = @Content(schema = @Schema(implementation = Void.class))),
            @ApiResponse(responseCode = "400", description = "Некорректные данные запроса или ошибка при выполнении транзакции", content = @Content(schema = @Schema(implementation = Validate.class))),
            @ApiResponse(responseCode = "401", description = "Пользователь не аутентифицирован")
    })
    @PreAuthorize("isAuthenticated()")
    @PostMapping("book")
    public ResponseEntity<Void> transaction(@RequestBody TransactionBookRequestDto dto){
        log.info("start method <<transaction>>. Dto: {}", dto);
        transactionService.transaction(dto);
        log.info("methode complete");
        return ResponseEntity.noContent().build();
    }


}
