package com.example.LibraryAPITestTask.analytics.controller;


import com.example.LibraryAPITestTask.analytics.serivce.AnalyticService;
import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.reader.dto.ReaderWithBookCount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Analytics API")
@RestController
@RequestMapping("api/analytics")
@RequiredArgsConstructor
@Slf4j
public class AnalyticsRestController {

    private final AnalyticService analyticService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/top-reader")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Список самых читающих клиентов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Если таких читателей несколько, то вернёт список. Если таких нет - пустой спико"),
            @ApiResponse(responseCode = "401", description = "Пользователь не аутентифицирован"
            )
    })
    public ResponseEntity<List<ReaderWithBookCount>> getTopReader() {
        log.info("start methode <<topReader>>");
        return ResponseEntity.ok(analyticService.getTopReader());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/top-author")
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "поиск самого популяроного автора")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Если такой автор есть, то вернёт его данные"),
            @ApiResponse(responseCode = "401", description = "Пользователь не аутентифицирован"
            )
    })
    public ResponseEntity<AuthorResponseDto> getTopAuthor(@RequestParam("from")LocalDateTime from,
                                                          @RequestParam("to") LocalDateTime to) {
        log.info("start methode <<topAuthor>>");
        return ResponseEntity.ok(analyticService.getTopAuthor(from, to));
    }


    @GetMapping("/not-return-book")
    @Operation(summary = "Метод который вернет список всех читателей отсортированных по убыванию количества не сданных книг")
    @ApiResponses(value = {@ApiResponse(responseCode = "200")})
    public ResponseEntity<List<ReaderWithBookCount>>  getReaderNotReturnBook() {
        log.info("start methode <<notReturnBook>>");
        return ResponseEntity.ok(analyticService.getReaderNotReturnBook());
    }



}
