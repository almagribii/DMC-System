package org.demo.repository;

import org.demo.model.RekamMedis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryRekamMedis extends MongoRepository<RekamMedis, String> {
    long countByIdPasien(String idPasien);
}
