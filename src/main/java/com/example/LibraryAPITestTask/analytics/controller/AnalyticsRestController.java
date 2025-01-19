package com.example.LibraryAPITestTask.analytics.controller;


import com.example.LibraryAPITestTask.analytics.serivce.AnalyticService;
import com.example.LibraryAPITestTask.author.dto.AuthorResponseDto;
import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("api/analytics")
@RequiredArgsConstructor
@Slf4j
public class AnalyticsRestController {

    private final AnalyticService analyticService;


    @GetMapping("/top-reader")
    public ResponseEntity<List<ReaderResponseDto>> getTopReader() {
        log.info("start methode <<topReader>>");
        return ResponseEntity.ok(analyticService.getReaderTopReader());
    }


    @GetMapping("/top-author")
    public ResponseEntity<AuthorResponseDto> getTopReader(@RequestParam("from")LocalDateTime from,
                                                      @RequestParam("to") LocalDateTime to) {
        log.info("start methode <<topAuthor>>");
        return ResponseEntity.ok(analyticService.getTopAuthor(from, to));
    }

    @GetMapping("/not-return-book")
    public ResponseEntity<List<ReaderResponseDto>>  getReaderNotReturnBook() {
        log.info("start methode <<notReturnBook>>");
        return ResponseEntity.ok(analyticService.getReaderNotReturnBook());
    }


}
