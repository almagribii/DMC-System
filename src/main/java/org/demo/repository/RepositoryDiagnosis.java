package org.demo.repository;

import org.demo.model.Diagnosis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryDiagnosis extends MongoRepository<Diagnosis, String> {
}
