package org.demo.repository;

import org.demo.model.Dokter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDokter extends MongoRepository<Dokter, String> {
    Dokter findByNipPegawai(String nipPegawai);
}
