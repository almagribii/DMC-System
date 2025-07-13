package org.demo.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import org.bson.types.ObjectId;

import org.demo.model.Dokter;
import org.demo.model.Pasien;
import org.demo.model.RekamMedis;
import org.demo.repository.RepositoryDokter;
import org.demo.repository.RepositoryPasien;
import org.demo.repository.RepositoryRekamMedis;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    private final RepositoryPasien repositoryPasien;
    private final RepositoryDokter repositoryDokter;
    private final RepositoryRekamMedis repositoryRekamMedis;


    public AuthService(RepositoryPasien repositoryPasien, RepositoryDokter repositoryDokter, RepositoryRekamMedis repositoryRekamMedis){
        this.repositoryPasien = repositoryPasien;
        this.repositoryDokter = repositoryDokter;
        this.repositoryRekamMedis = repositoryRekamMedis;
    }

    public UserAuthResult authenticateUser(String identifier, String password){
        Dokter dokter = repositoryDokter.findByNipPegawai(identifier);
        if (dokter != null){
            if (password.equals(dokter.getPasswordHash())) {
                return new UserAuthResult(identifier, "Dokter", null, true);
            }
        }

        Pasien pasien = repositoryPasien.findByNomorIdentitas(identifier);
        if (pasien != null){
            if (password.equals(pasien.getPasswordHash())) {
                String pasienStatus = getPasienStatus(pasien.getId());
                return new UserAuthResult(identifier, "Pasien",pasienStatus, true);
            }
        }
        return new UserAuthResult(identifier, null, null, false);
    }

    private String getPasienStatus(String pasienId){

        long count = repositoryRekamMedis.countByIdPasien(pasienId);
        if (count > 0) {
            return "Pasien Lama";
        } else {
            return "Pasien Baru";
        }
    }

    public static class UserAuthResult {
        private String identifier;
        private String role;
        private String pasienType;
        private boolean isAuthenticated;

        public UserAuthResult(String identifier, String role, String pasienType, boolean isAuthenticated) {
            this.identifier = identifier;
            this.role = role;
            this.pasienType = pasienType;
            this.isAuthenticated = isAuthenticated;
        }

        public String getIdentifier(){return identifier;}
        public void setIdentifier(String identifier){this.identifier = identifier;}

        public String getRole(){return role;}
        public void setRole(String role){this.role = role;}

        public String getPasienType(){return pasienType;}
        public void setPasienType(String pasienType){this.pasienType = pasienType;}

        public boolean isAuthenticated() {
            return isAuthenticated;
        }

        public void setAuthenticated(boolean isAuthenticated){
            this.isAuthenticated = isAuthenticated;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserAuthResult that = (UserAuthResult) o;
            return isAuthenticated == that.isAuthenticated && Objects.equals(identifier, that.identifier) && Objects.equals(role, that.role) && Objects.equals(pasienType, that.pasienType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(identifier, role, pasienType, isAuthenticated);
        }

        @Override
        public String toString(){
            if (isAuthenticated){
                if ("Pasien".equals(role)){
                    return "Autentikasi BERHASIL. user:" + identifier + ", Peran: " + role + ", Tipe Pasien: " + pasienType;
                } else {
                    return "Autentikasi BERHASIL. User: " + identifier + ", Peran: " + role;
                }
            } else {
                return "Autentikasi GAGAL untuk user: " + identifier;
            }
        }
    }
}