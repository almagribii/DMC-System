package org.demo.repository;

import org.demo.model.TindakanMedis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryTindakanMedis extends MongoRepository<TindakanMedis, String> {
}
