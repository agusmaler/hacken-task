package com.example.csv.business.dto;

import jakarta.ws.rs.FormParam;
import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@Getter
@Schema
public class CsvFileRequestDto {

    @FormParam("file")
    private FileUpload file;

}
