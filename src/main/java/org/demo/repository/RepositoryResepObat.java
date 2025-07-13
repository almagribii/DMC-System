package org.demo.repository;

import org.demo.model.ResepObat;
import org.springframework.data.mongodb.repository.MongoRepository;

interface RepositoryResepObat extends MongoRepository<ResepObat, String> {
}
