package com.example.LibraryAPITestTask.analytics.serivce;

import com.example.LibraryAPITestTask.analytics.dto.TopReaderResponseDto;

import java.util.List;

public interface AnalyticService {

    List<TopReaderResponseDto> getReaderTopReader();
}
