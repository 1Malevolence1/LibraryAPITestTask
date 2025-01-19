package com.example.LibraryAPITestTask.analytics.controller;


import com.example.LibraryAPITestTask.analytics.serivce.AnalyticService;
import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.transaction.controller.ReaderWithBookCount;
import com.example.LibraryAPITestTask.transaction.exception.Validate;
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
    public ResponseEntity<List<ReaderWithBookCount>> getTopReader() {
        log.info("start methode <<topReader>>");
        return ResponseEntity.ok(analyticService.getTopReader());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/top-author")
    public ResponseEntity<AuthorResponseDto> getTopAuthor(@RequestParam("from")LocalDateTime from,
                                                          @RequestParam("to") LocalDateTime to) {
        log.info("start methode <<topAuthor>>");
        return ResponseEntity.ok(analyticService.getTopAuthor(from, to));
    }


    @GetMapping("/not-return-book")
    public ResponseEntity<List<ReaderWithBookCount>>  getReaderNotReturnBook() {
        log.info("start methode <<notReturnBook>>");
        return ResponseEntity.ok(analyticService.getReaderNotReturnBook());
    }


    @ExceptionHandler(MissingServletRequestParameterException .class)
    public ResponseEntity<Validate> handlerMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Validate(e.getMessage()));
    }

}
