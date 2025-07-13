//package org.demo;
//
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import org.bson.codecs.configuration.CodecProvider;
//import org.bson.codecs.configuration.CodecRegistry;
//import org.bson.codecs.pojo.PojoCodecProvider;
//import com.mongodb.client.MongoCollection;
//import org.bson.types.ObjectId;
//
//// Import semua model yang digunakan
//import org.demo.model.Dokter;
//import org.demo.model.Pasien;
//import org.demo.model.RekamMedis;
//import org.demo.model.Kontak;
//import org.demo.model.ProdiInfo;
//import org.demo.model.PemeriksaanFisik;
//import org.demo.model.Diagnosis;
//import org.demo.model.TindakanMedis;
//import org.demo.model.ResepObat;
//
//import org.demo.service.AuthService;
//
//import java.util.Scanner;
//import java.util.Date;
//import java.util.List;
//
//
//import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
//import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
//
//public class DmcApp {
//    public static void main(String[] args) {
//        String connectionString = "mongodb://localhost:27017";
//
//        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
//        CodecRegistry pojoCodecRegistry = fromRegistries(
//                MongoClientSettings.getDefaultCodecRegistry(),
//                fromProviders(pojoCodecProvider)
//        );
//
//        MongoClient mongoClient = null;
//        Scanner scanner = null;
//        try {
//            MongoClientSettings settings = MongoClientSettings.builder()
//                    .applyConnectionString(new com.mongodb.ConnectionString(connectionString))
//                    .codecRegistry(pojoCodecRegistry)
//                    .build();
//
//            mongoClient = MongoClients.create(settings);
//
//            MongoDatabase database = mongoClient.getDatabase("DMC");
//            System.out.println("Berhasil Terhubung ke database: " + database.getName());
//
//            setupInitialData(database); // <-- Panggil ini sebelum inisialisasi Scanner untuk pertama kali
//
//            // --- PERBAIKAN PENTING DI SINI ---
//            // Inisialisasi Scanner hanya sekali dan jangan tutup System.in
//            scanner = new Scanner(System.in);
//
//            AuthService authService = new AuthService(database);
//            System.out.println("\n--- Melakukan Autentikasi Menggunakan AuthService ---"); // Perbaiki typo "Authentikasi"
//
//            System.out.println("\n--- Sistem Autentikasi DMC ---");
//            System.out.print("Masukkan Username (NIM/NIP): "); // Gunakan print
//            String username = scanner.nextLine();
//
//            System.out.print("Masukkan Password: "); // Gunakan print
//            String password = scanner.nextLine();
//
//            AuthService.UserAuthResult result = authService.autheticationUser(username, password); // Perbaiki typo "autheticationUser"
//            System.out.println(result);
//
//            if (result.isAuthenticated()) {
//                System.out.println("Selamat Datang, " + result.getIdentifier() + "!");
//                if ("Dokter".equals(result.getRole())){
//                    System.out.println("Anda Masuk Sebagai Dokter. Akses menu manajemen pasien.");
//                } else if ("Pasien".equals(result.getRole())) {
//                    System.out.println("Anda Masuk Sebagai Pasien. Status: " + result.getPasienType() + ".");
//                }
//            } else {
//                System.out.println("Login gagal. Username atau Password salah.");
//            }
//
//        } catch (Exception e){
//            System.err.println("Terjadi kesalahan saat koneksi atau operasi MongoDB: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (mongoClient != null){
//                mongoClient.close();
//                System.out.println("Koneksi MongoDb ditutup");
//            }
//        }
//    }
//
//    private static void setupInitialData(MongoDatabase database){
//        // Mengakses koleksi dengan tipe POJO
//        MongoCollection<Pasien> pasienCollection = database.getCollection("pasien", Pasien.class);
//        MongoCollection<Dokter> dokterCollection = database.getCollection("dokter", Dokter.class);
//        MongoCollection<RekamMedis> rekamMedisCollection = database.getCollection("rekamMedis", RekamMedis.class);
//
//        // Membersihkan koleksi untuk pengujian ulang
//        pasienCollection.drop();
//        dokterCollection.drop();
//        rekamMedisCollection.drop();
//
//        // Menambahkan Pasien
//        Pasien pasien1 = new Pasien(
//                new ObjectId(),
//                "passwordPasien",
//                "NIM",
//                "2023001",
//                "Ahmad Fadillah", // Menggunakan nama konsisten
//                new Date(),
//                "Laki-laki",
//                "A+",
//                new Kontak("ahmad@email.com", "08123", "Asrama Mahasiswa"),
//                "Mahasiswa",
//                new ProdiInfo(new ObjectId(), "Teknik Informatika"),
//                new Date(),
//                List.of("Debu"),
//                List.of("Asma"),
//                "Catatan khusus asma."
//        );
//        pasienCollection.insertOne(pasien1);
//
//        Pasien pasien2 = new Pasien(
//                new ObjectId(),
//                "passwordPasien2", // Pastikan password berbeda untuk testing pasien baru
//                "NIM",
//                "2023002",
//                "Budi Santoso", // Menggunakan nama konsisten
//                new Date(),
//                "Laki-laki",
//                "B+",
//                new Kontak("budi@email.com", "08456", "Asrama Dosen"),
//                "Mahasiswa",
//                new ProdiInfo(new ObjectId(), "Pendidikan Bahasa Arab"),
//                new Date(),
//                List.of("Udang"),
//                List.of(),
//                "Tidak ada riwayat alergi."
//        );
//        pasienCollection.insertOne(pasien2);
//
//        // Menambahkan Dokter
//        Dokter dokter1 = new Dokter(
//                new ObjectId(),
//                "passwordDokter", // Pastikan passwordHash di posisi kedua
//                "NIP001",
//                "dr. Fulan", // Menggunakan nama konsisten
//                "Dokter Umum",
//                "SIP12345",
//                new Kontak("fulan.dr@unida.gontor.ac.id", "08900", "Poli Umum"),
//                true
//        );
//        dokterCollection.insertOne(dokter1);
//
//        // Menambahkan Rekam Medis untuk Pasien Lama (pasien1)
//        RekamMedis rm1 = new RekamMedis(
//                pasien1.getId(), pasien1.getNomorIdentitas(), pasien1.getNamaLengkap(), new Date(),
//                "Pemeriksaan", "Batuk", "Anamnesa umum",
//                new PemeriksaanFisik("120/80 mmHg", 38.5, "80 bpm", "18 bpm", 65, 170, "Konjungtiva anemis."),
//                List.of(new Diagnosis("J06.9", "Infeksi Saluran Pernapasan Akut")),
//                List.of(new TindakanMedis("Pemberian resep obat", "Edukasi pasien.")),
//                List.of(new ResepObat(new ObjectId(), "Paracetamol", "500mg", 10, "Tablet", "3x1")),
//                "Catatan dokter RM1", dokter1.getId(), dokter1.getNamaLengkap(), "Selesai", null, null
//        );
//        rekamMedisCollection.insertOne(rm1);
//
//        System.out.println("\nData awal untuk pengujian berhasil disiapkan.");
//    }
//}

//-----------------Auth Ketika masih manual menggunakan collection--------------------------------------------------