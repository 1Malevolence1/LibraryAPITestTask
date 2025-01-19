package com.example.LibraryAPITestTask.analytics.controller;


import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;
import com.example.LibraryAPITestTask.analytics.serivce.AnalyticService;
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
    public ResponseEntity<List<TopReaderResponseDto>> topReader(){
        log.info("start methode <<topReader>>");
        return ResponseEntity.ok(analyticService.getReaderTopReader());
    }
}
