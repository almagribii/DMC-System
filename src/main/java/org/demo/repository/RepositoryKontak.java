package org.demo.repository;

import org.demo.model.Kontak;
import org.springframework.data.mongodb.repository.MongoRepository;

interface RepositoryKontak extends MongoRepository<Kontak, String> {
}
