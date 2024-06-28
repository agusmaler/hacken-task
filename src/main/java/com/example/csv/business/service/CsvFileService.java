package com.example.csv.business.service;

import com.example.csv.business.domain.CsvFile;
import com.example.csv.business.dto.CsvFileResponseDto;
import com.example.csv.business.dto.FileCsvRequestDto;
import com.example.csv.business.repository.CsvFileRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CsvFileService {

    @Inject
    CsvFileRepository repository;

    @Transactional
    public CsvFileResponseDto upload(FileCsvRequestDto request) throws IOException {
        FileUpload file = request.getFile();
        String content = Files.readString(file.uploadedFile());

        CsvFile csvFile = CsvFile.builder()
                .fileName(file.fileName())
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();

        this.repository.upload(csvFile);

        return CsvFileResponseDto.builder()
                .fileName(file.fileName())
                .build();
    }

    public List<CsvFile> search(String query) {
        return repository.search(query);
    }


}
