package org.demo.repository;

import org.demo.model.Dokter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryDokter extends MongoRepository<Dokter, String> {
    
}
