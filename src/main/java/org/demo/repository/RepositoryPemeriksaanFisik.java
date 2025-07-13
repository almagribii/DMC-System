package org.demo.repository;

import org.demo.model.PemeriksaanFisik;
import org.springframework.data.mongodb.repository.MongoRepository;

interface RepositoryPemeriksaanFisik extends MongoRepository<PemeriksaanFisik, String> {
}
