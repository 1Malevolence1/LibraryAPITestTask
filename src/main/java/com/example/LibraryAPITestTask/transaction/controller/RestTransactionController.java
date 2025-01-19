package com.example.LibraryAPITestTask.transaction.controller;


import com.example.LibraryAPITestTask.transaction.dto.TransactionBookRequestDto;
import com.example.LibraryAPITestTask.transaction.model.TypeOperation;
import com.example.LibraryAPITestTask.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
@RequiredArgsConstructor
@Slf4j
public class RestTransactionController {

    private final TransactionService transactionService;

    @PostMapping("book")
    public ResponseEntity<Void> transaction(@RequestBody TransactionBookRequestDto dto,
                                                    @RequestParam(name = "operation") TypeOperation typeOperation){
        log.info("start method <<transaction>>. Dto: {}", dto);
        transactionService.transaction(dto, typeOperation);
        log.info("methode complete");
        return ResponseEntity.noContent().build();
    }
}
