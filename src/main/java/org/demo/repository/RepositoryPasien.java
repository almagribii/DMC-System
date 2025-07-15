
package org.demo.repository;

import org.demo.model.Pasien;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query; // PASTIKAN INI ADA
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPasien extends MongoRepository<Pasien, String> {
    // Pastikan query-nya persis seperti ini
    Pasien findByNomorIdentitas(String nomorIdentitas);
}