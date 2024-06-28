package com.example.csv.business.dto;

import lombok.Builder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@Builder
@Schema
public class CsvFileResponseDto {

    private String fileName;
    private LocalDateTime createdAt;



}
