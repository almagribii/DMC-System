package org.demo.repository;

import org.demo.model.Obat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryObat extends MongoRepository<Obat, String> {
}
