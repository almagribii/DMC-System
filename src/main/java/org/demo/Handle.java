////package org.demo;
////
////import com.mongodb.MongoClientSettings;
////import com.mongodb.client.MongoClient;
////import com.mongodb.client.MongoClients;
////import com.mongodb.client.MongoDatabase;
////import com.mongodb.client.MongoCollection; // Perlu untuk setupInitialData
////import org.bson.codecs.configuration.CodecProvider;
////import org.bson.codecs.configuration.CodecRegistry;
////import org.bson.codecs.pojo.PojoCodecProvider;
////
////// Import model-model Anda
////import org.demo.model.Pasien;
////import org.demo.model.Dokter;
////import org.demo.model.Kontak;
////import org.demo.model.ProdiInfo;
////import org.demo.model.RekamMedis;
////import org.demo.model.PemeriksaanFisik;
////import org.demo.model.Diagnosis;
////import org.demo.model.TindakanMedis;
////import org.demo.model.ResepObat;
////
////// Import AuthService
////import org.demo.service.AuthService;
////import org.bson.Document; // Untuk query filter atau setupInitialData
////import org.bson.types.ObjectId; // Untuk setupInitialData
////
////import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
////import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
////
////import java.util.Arrays;
////import java.util.Date;
////import java.util.List;
////import java.util.Scanner; // <--- Import ini untuk membaca input
////
////public class DmcApp {
////    public static void main(String[] args) {
////        String connectionString = "mongodb://localhost:27017";
////
////        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
////        CodecRegistry pojoCodecRegistry = fromRegistries(
////                MongoClientSettings.getDefaultCodecRegistry(),
////                fromProviders(pojoCodecProvider)
////        );
////
////        MongoClient mongoClient = null;
////        Scanner scanner = null; // Deklarasikan scanner di luar try untuk finally
////        try {
////            MongoClientSettings settings = MongoClientSettings.builder()
////                    .applyConnectionString(new com.mongodb.ConnectionString(connectionString))
////                    .codecRegistry(pojoCodecRegistry)
////                    .build();
////
////            mongoClient = MongoClients.create(settings);
////            MongoDatabase database = mongoClient.getDatabase("DMC");
////            System.out.println("Berhasil Terhubung ke database: " + database.getName());
////
////            // --- Bagian Persiapan Data Awal (Hanya untuk contoh, bisa dihapus setelah data ada) ---
////            setupInitialData(database);
////            // --- Akhir Bagian Persiapan Data ---
////
////            // --- Menginisialisasi AuthService ---
////            AuthService authService = new AuthService(database);
////
////            // --- Membaca Input dari Konsol ---
////            scanner = new Scanner(System.in); // Buat objek Scanner
////
////            System.out.println("\n--- Sistem Autentikasi DMC ---");
////            System.out.print("Masukkan Username (NIM/NIP): ");
////            String username = scanner.nextLine(); // Membaca baris teks dari konsol
////
////            System.out.print("Masukkan Password: ");
////            String password = scanner.nextLine(); // Membaca baris teks dari konsol
////
////            // --- Melakukan Autentikasi dengan Input Pengguna ---
////            AuthService.UserAuthResult result = authService.authenticateUser(username, password);
////            System.out.println(result); // Menampilkan hasil autentikasi
////
////            // Contoh logika setelah autentikasi
////            if (result.isAuthenticated()) {
////                System.out.println("Selamat datang, " + result.getIdentifier() + "!");
////                if ("Dokter".equals(result.getRole())) {
////                    System.out.println("Anda masuk sebagai Dokter. Akses menu manajemen pasien.");
////                    // Di sini Anda bisa memanggil fungsi/menu untuk Dokter
////                } else if ("Pasien".equals(result.getRole())) {
////                    System.out.println("Anda masuk sebagai Pasien. Status Anda: " + result.getPasienType() + ".");
////                    // Di sini Anda bisa memanggil fungsi/menu untuk Pasien
////                }
////            } else {
////                System.out.println("Login gagal. Username atau password salah.");
////            }
////
////        } catch (Exception e){
////            System.err.println("Terjadi kesalahan saat koneksi atau operasi MongoDB: " + e.getMessage());
////            e.printStackTrace();
////        } finally {
////            if (mongoClient != null){
////                mongoClient.close();
////                System.out.println("Koneksi MongoDb ditutup");
////            }
////            if (scanner != null) { // Pastikan scanner juga ditutup
////                scanner.close();
////                System.out.println("Scanner ditutup.");
////            }
////        }
////    }
////
////    // Metode setupInitialData tetap sama seperti sebelumnya
////    private static void setupInitialData(MongoDatabase database) {
////        database.getCollection("pasien", Pasien.class).drop();
////        database.getCollection("dokter", Dokter.class).drop();
////        database.getCollection("rekamMedis", RekamMedis.class).drop();
////
////        Pasien pasien1 = new Pasien(
////                "NIM", "2023001", "Ahmad Fadillah", new Date(), "Laki-laki", "A+",
////                new Kontak("ahmad@email.com", "08123", "Asrama"), "Mahasiswa",
////                new ProdiInfo(new ObjectId(), "Teknik Informatika"), new Date(),
////                List.of("Debu"), List.of("Asma"), "Catatan", "passwordPasien"
////        );
////        database.getCollection("pasien", Pasien.class).insertOne(pasien1);
////
////        Pasien pasien2 = new Pasien(
////                "NIM", "2023002", "Budi Santoso", new Date(), "Laki-laki", "B+",
////                new Kontak("budi@email.com", "08456", "Asrama"), "Mahasiswa",
////                new ProdiInfo(new ObjectId(), "Kedokteran"), new Date(),
////                List.of("Udang"), List.of(), "Catatan", "passwordPasien2"
////        );
////        database.getCollection("pasien", Pasien.class).insertOne(pasien2);
////
////        Dokter dokter1 = new Dokter(
////                new ObjectId(), "NIP001", "dr. Fulan", "Dokter Umum", "SIP12345",
////                new Kontak("fulan.dr@unida.gontor.ac.id", "08900", "Klinik"), true, "passwordDokter"
////        );
////        database.getCollection("dokter", Dokter.class).insertOne(dokter1);
////
////        RekamMedis rm1 = new RekamMedis(
////                pasien1.getId(), pasien1.getNomorIdentitas(), pasien1.getNamaLengkap(), new Date(),
////                "Pemeriksaan", "Batuk", "Anamnesa",
////                new PemeriksaanFisik("120/80 mmHg", 38.5, "80 bpm", "18 bpm", 65, 170, "Konjungtiva anemis."),
////                List.of(new Diagnosis("J06.9", "ISPA")),
////                List.of(new TindakanMedis("Resep Obat", "Edukasi")),
////                List.of(new ResepObat(new ObjectId(), "Paracetamol", "500mg", 10, "Tablet", "3x1")),
////                "Catatan RM", dokter1.getId(), dokter1.getNamaLengkap(), "Selesai", null, null
////        );
////        database.getCollection("rekamMedis", RekamMedis.class).insertOne(rm1);
////
////        System.out.println("\nData awal untuk pengujian berhasil disiapkan.");
////    }
////}
//
//// src/main/java/org/demo/service/AuthService.java
//
//package org.demo.service;
//
//import org.demo.model.Dokter;
//import org.demo.model.Pasien;
//import org.demo.model.RekamMedis;
//import org.demo.repository.RepositoryPasien; // Perlu ini untuk menyimpan Pasien baru
//import org.demo.repository.RepositoryRekamMedis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//
//@Service
//public class AuthService {
//    private final RepositoryPasien repositoryPasien; // Perlu untuk menyimpan pasien baru
//    private final RepositoryRekamMedis repositoryRekamMedis;
//    private final MongoTemplate mongoTemplate; // Untuk mencari Dokter dan Pasien
//
//    @Autowired
//    public AuthService(RepositoryPasien repositoryPasien, RepositoryRekamMedis repositoryRekamMedis, MongoTemplate mongoTemplate) {
//        this.repositoryPasien = repositoryPasien;
//        this.repositoryRekamMedis = repositoryRekamMedis;
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    public UserAuthResult authenticateUser(String identifier, String password) {
//        // --- Bagian Dokter ---
//        Query queryDokter = new Query(Criteria.where("nipPegawai").is(identifier));
//        Dokter dokter = mongoTemplate.findOne(queryDokter, Dokter.class);
//
//        if (dokter != null) {
//            if (password != null && password.equals(dokter.getPasswordHash())) {
//                return new UserAuthResult(identifier, "Dokter", null, true, false); // Menambah isNewUser = false
//            }
//        }
//
//        // --- Bagian Pasien ---
//        Query queryPasien = new Query(Criteria.where("nomorIdentitas").is(identifier));
//        Pasien pasien = mongoTemplate.findOne(queryPasien, Pasien.class);
//
//        if (pasien != null) { // Pasien ditemukan (lama atau baru terdaftar)
//            if (password != null && password.equals(pasien.getPasswordHash())) {
//                String pasienStatus = getPasienStatus(pasien.getId());
//                return new UserAuthResult(identifier, "Pasien", pasienStatus, true, false); // Menambah isNewUser = false
//            } else {
//                // Pasien ditemukan tapi password salah
//                return new UserAuthResult(identifier, null, null, false, false); // Bukan user baru
//            }
//        } else { // Pasien TIDAK ditemukan sama sekali -> Ini adalah POTENSI PASIEN BARU
//            return new UserAuthResult(identifier, null, "Pasien Baru", false, true); // Menandakan isNewUser = true
//        }
//    }
//
//    private String getPasienStatus(String pasienId) {
//        long count = repositoryRekamMedis.countByIdPasien(pasienId);
//        if (count > 0) {
//            return "Pasien Lama";
//        } else {
//            return "Pasien Baru"; // Pasien yang sudah login, tapi belum ada rekam medis
//        }
//    }
//
//    // --- Metode Baru: Registrasi Pasien Baru ---
//    public Pasien registerNewPasien(Pasien newPasien) {
//        // Lakukan validasi dasar (opsional: pastikan nomorIdentitas unik, dll.)
//        Pasien existingPasien = repositoryPasien.findByNomorIdentitas(newPasien.getNomorIdentitas());
//        if (existingPasien != null) {
//            throw new IllegalArgumentException("Nomor Identitas sudah terdaftar.");
//        }
//        // Simpan pasien baru ke database
//        return repositoryPasien.save(newPasien);
//    }
//
//
//    // --- Modifikasi Kelas UserAuthResult ---
//    public static class UserAuthResult {
//        private String identifier;
//        private String role;
//        private String pasienType;
//        private boolean isAuthenticated;
//        private boolean isNewUser; // <--- Tambahkan field ini
//
//        public UserAuthResult(String identifier, String role, String pasienType, boolean isAuthenticated, boolean isNewUser) {
//            this.identifier = identifier;
//            this.role = role;
//            this.pasienType = pasienType;
//            this.isAuthenticated = isAuthenticated;
//            this.isNewUser = isNewUser;
//        }
//
//        // Getters dan Setters untuk isNewUser
//        public boolean isNewUser() { return isNewUser; }
//        public void setNewUser(boolean newUser) { isNewUser = newUser; }
//
//        // ... (getter, setter, equals, hashCode, toString lainnya tetap sama) ...
//        @Override
//        public String toString(){
//            if (isAuthenticated){
//                if ("Pasien".equals(role)){
//                    return "Autentikasi BERHASIL. user:" + identifier + ", Peran: " + role + ", Tipe Pasien: " + pasienType;
//                } else {
//                    return "Autentikasi BERHASIL. User: " + identifier + ", Peran: " + role;
//                }
//            } else {
//                if (isNewUser) {
//                    return "Autentikasi GAGAL. User " + identifier + " adalah PASIEN BARU. Harap daftar.";
//                } else {
//                    return "Autentikasi GAGAL. Username atau Password salah.";
//                }
//            }
//        }
//    }
//}