package org.demo.repository;

import org.demo.model.Pasien;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPasien extends MongoRepository<Pasien, String> {

//    Spring akan ototmatis membuat implementasinya
    Pasien findByNomorIdentitas(String nomorIdentitas);
}
