package com.example.csv.business.repository;

import com.example.csv.business.domain.CsvFile;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CsvFileRepository implements PanacheRepository<CsvFile> {

    public void upload(CsvFile csvFile) {
        this.persist(csvFile);
    }

    public List<CsvFile> search(String query) {
        String likePattern = "%" + query.toLowerCase() + "%";
        return list("lower(content) like ?1", likePattern);
    }

}
