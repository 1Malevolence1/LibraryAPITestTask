package com.example.LibraryAPITestTask.analytics.controller;


import com.example.LibraryAPITestTask.analytics.serivce.AnalyticService;
import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.transaction.controller.ReaderWithBookCount;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api/analytics")
@RequiredArgsConstructor
@Slf4j
public class AnalyticsRestController {

    private final AnalyticService analyticService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/top-reader")
    @Operation(summary = "Список самых читающих клиентов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Если таких читателей несколько, то вернёт список. Если таких нет - пустой спико"),
    })
    public ResponseEntity<List<ReaderWithBookCount>> getTopReader() {
        log.info("start methode <<topReader>>");
        return ResponseEntity.ok(analyticService.getTopReader());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/top-author")
    @Operation(summary = "поиск самого популяроного автора")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Если такой автор есть, то вернёт его данные, аначе - null"),
    })
    public ResponseEntity<AuthorResponseDto> getTopAuthor(@RequestParam("from")LocalDateTime from,
                                                          @RequestParam("to") LocalDateTime to) {
        log.info("start methode <<topAuthor>>");
        return ResponseEntity.ok(analyticService.getTopAuthor(from, to));
    }


    @GetMapping("/not-return-book")
    @Operation(summary = "Метод который вернет список всех читателей отсортированных по убыванию количества не сданных книг")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<List<ReaderWithBookCount>>  getReaderNotReturnBook() {
        log.info("start methode <<notReturnBook>>");
        return ResponseEntity.ok(analyticService.getReaderNotReturnBook());
    }


    @ExceptionHandler(MissingServletRequestParameterException .class)
    public ResponseEntity<Validate> handlerMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Validate(e.getMessage()));
    }

}
