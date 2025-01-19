package com.example.LibraryAPITestTask.analytics.controller;


import com.example.LibraryAPITestTask.analytics.serivce.AnalyticService;
import com.example.LibraryAPITestTask.reader.dto.ReaderResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/analytics")
@RequiredArgsConstructor
@Slf4j
public class AnalyticsRestController {

    private final AnalyticService analyticService;

    @GetMapping("/top-reader")
    public ResponseEntity<List<ReaderResponseDto>> topReader() {
        log.info("start methode <<topReader>>");
        return ResponseEntity.ok(analyticService.getReaderTopReader());
    }

    @GetMapping("/not-return-book")
    public ResponseEntity<List<ReaderResponseDto>>  notReturnBook() {
        log.info("start methode <<notReturnBook>>");
        return ResponseEntity.ok(analyticService.getReaderNotReturnBook());
    }
}
