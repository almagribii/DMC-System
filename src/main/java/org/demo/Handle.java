package org.demo; // Buat package baru untuk layanan

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.demo.model.Dokter;
import org.demo.model.Pasien;

import java.util.Date;

public class Handle {

    private final MongoCollection<Pasien> pasienCollection;
    private final MongoCollection<Dokter> dokterCollection;
    private final MongoCollection<Document> rekamMedisCollection; // Untuk cek pasien lama/baru

    // Konstruktor untuk menginisialisasi koleksi-koleksi yang dibutuhkan
    public Handle(MongoDatabase database) {
        this.pasienCollection = database.getCollection("pasien", Pasien.class);
        this.dokterCollection = database.getCollection("dokter", Dokter.class);
        // Kita perlu RekamMedisCollection sebagai Document karena kita hanya butuh ID untuk cek keberadaan
        this.rekamMedisCollection = database.getCollection("rekamMedis", Document.class);
    }

    // --- Metode untuk Autentikasi dan Otorisasi ---
    public UserAuthResult2 authenticateUser(String nomorIdentitas, String password) {
        // Coba cari di koleksi Dokter
        Dokter dokter = dokterCollection.find(new Document("nipPegawai", nomorIdentitas)).first();
        if (dokter != null) {
            // Dalam aplikasi nyata: gunakan BCrypt.checkpw(password, dokter.getPasswordHash())
            if (password.equals(dokter.getPasswordHash())) { // Contoh sederhana, JANGAN DI PRODUKSI!
                return new UserAuthResult2(nomorIdentitas, "Dokter", null, true);
            }
        }

        // Coba cari di koleksi Pasien
        Pasien pasien = pasienCollection.find(new Document("nomorIdentitas", nomorIdentitas)).first();
        if (pasien != null) {
            // Dalam aplikasi nyata: gunakan BCrypt.checkpw(password, pasien.getPasswordHash())
            if (password.equals(pasien.getPasswordHash())) { // Contoh sederhana, JANGAN DI PRODUKSI!
                String pasienStatus = getPasienStatus(pasien.getId());
                return new UserAuthResult2(nomorIdentitas, "Pasien", pasienStatus, true);
            }
        }

        // Jika tidak ditemukan atau password salah
        return new UserAuthResult2(nomorIdentitas, null, null, false);
    }

    // Metode untuk mengecek status pasien (Lama/Baru)
    private String getPasienStatus(ObjectId pasienId) {
        // Cari setidaknya satu rekam medis untuk pasien ini
        Document rekamMedis = rekamMedisCollection.find(new Document("idPasien", pasienId)).first();
        if (rekamMedis != null) {
            return "Pasien Lama"; // Jika ada rekam medis, berarti sudah pernah berkunjung
        } else {
            return "Pasien Baru"; // Jika belum ada rekam medis
        }
    }

    // --- Kelas Pembantu untuk Hasil Autentikasi ---
    public static class UserAuthResult2 {
        private String identifier; // NIM/NIDN/NIK
        private String role;       // "Dokter" atau "Pasien"
        private String pasienType; // "Pasien Lama" atau "Pasien Baru" (hanya jika role Pasien)
        private boolean isAuthenticated;

        public UserAuthResult2(String identifier, String role, String pasienType, boolean isAuthenticated) {
            this.identifier = identifier;
            this.role = role;
            this.pasienType = pasienType;
            this.isAuthenticated = isAuthenticated;
        }

        public String getIdentifier() { return identifier; }
        public String getRole() { return role; }
        public String getPasienType() { return pasienType; }
        public boolean isAuthenticated() { return isAuthenticated; }

        @Override
        public String toString() {
            if (isAuthenticated) {
                if ("Pasien".equals(role)) {
                    return "Autentikasi BERHASIL. User: " + identifier + ", Peran: " + role + ", Tipe Pasien: " + pasienType;
                } else {
                    return "Autentikasi BERHASIL. User: " + identifier + ", Peran: " + role;
                }
            } else {
                return "Autentikasi GAGAL untuk user: " + identifier;
            }
        }
    }
}