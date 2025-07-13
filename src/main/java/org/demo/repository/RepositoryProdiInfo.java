package org.demo.repository;

import org.demo.model.ProdiInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryProdiInfo extends MongoRepository<ProdiInfo, String> {
}
