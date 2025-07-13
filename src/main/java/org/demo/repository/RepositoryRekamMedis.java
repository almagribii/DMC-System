package org.demo.repository;

import org.demo.model.RekamMedis;
import org.springframework.data.mongodb.repository.MongoRepository;

interface RepositoryRekamMedis extends MongoRepository<RekamMedis, String> {
}
