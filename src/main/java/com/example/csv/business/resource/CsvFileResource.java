package com.example.csv.business.resource;

import com.example.csv.business.dto.FileCsvRequestDto;
import com.example.csv.business.filters.interfaces.ValidCsv;
import com.example.csv.business.service.CsvFileService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;



@Path("/files")
public class CsvFileResource {

    @Inject
    CsvFileService service;

    @POST
    @Path("/csv")
    @ValidCsv
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadCsvFile(FileCsvRequestDto csvFile) throws IOException {
        return Response.status(Response.Status.CREATED).entity(service.upload(csvFile)).build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchCsvFile(@QueryParam("query") String query) {
        return Response.ok(service.search(query)).build();
    }


}
