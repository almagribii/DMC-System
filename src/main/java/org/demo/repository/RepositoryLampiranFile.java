package org.demo.repository;

import org.demo.model.LampiranFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryLampiranFile extends MongoRepository<LampiranFile, String> {
}
