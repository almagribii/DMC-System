package org.demo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.demo.model.Dokter;
import org.demo.model.Pasien;
import org.demo.model.RekamMedis;
import org.demo.model.Kontak;
import org.demo.model.ProdiInfo;
import org.demo.model.PemeriksaanFisik;
import org.demo.model.Diagnosis;
import org.demo.model.TindakanMedis;
import org.demo.model.ResepObat;
import org.demo.service.AuthService;

import java.util.Scanner;
import java.util.Date; // <-- Tambahkan
import java.util.List; // <-- Tambahkan
import java.util.Arrays; // <-- Tambahkan, jika menggunakan Arrays.asList
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DmcApp {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";

//        ini adalah bagian yang memberitahu driver bahwasanya kita ingin mapping otomatis
        CodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();

//        ini memastikan driver juga bisa menangani tipe dasar seperti String, Integer, ObjectId, dll
        CodecRegistry codecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(codecProvider)
        );

        MongoClient mongoClient = null;
        Scanner scanner = null;
        try {
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(connectionString))
                    .codecRegistry(codecRegistry)
                    .build();

            mongoClient = MongoClients.create(settings);

            MongoDatabase database = mongoClient.getDatabase("DMC");
            System.out.println("Berhasil Terhubung ke database: " + database.getName());

            setupInitialData(database);

            scanner = new Scanner(System.in);

            AuthService authService = new AuthService(database);
            System.out.println("\n --- Melakukan Authentikasi Menggunakan Auth Service ---");

            System.out.println("\n --- Sistem Autentikasi DMC ---");
            System.out.println("Masukkan Username (NIM/NIP)");
            String username = scanner.nextLine();

            System.out.println("Masukkan Password: ");
            String password = scanner.nextLine();

            AuthService.UserAuthResult result = authService.autheticationUser(username, password);
            System.out.println(result);

            if (result.isAuthenticated()) {
                System.out.println("Selamat Datang, " + result.getIdentifier() + "!");
                if ("Dokter".equals(result.getRole())){
                    System.out.println("Anda Masuk Sebagai Dokter. Akses menu manajemen pasien.");
                } else if ("Pasien".equals(result.getRole())) {
                    System.out.println("Anda Masuk Sebagai Pasien" + result.getPasienType() + ".");
                }
            } else {
                System.out.println("Login gagal. Username Atau Password salah.");
            }

        } catch (Exception e){
            System.out.println("Terjadi kesalahan saat koneksi atau operasi MongoDB: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (mongoClient != null){
                mongoClient.close();
                System.out.println("Koneksi MongoDb ditutup");
            }
            if (scanner != null) { // Pastikan scanner juga ditutup
                System.out.println("Scanner ditutup.");
            }
        }
    }

    private static void setupInitialData(MongoDatabase database){
        database.getCollection("pasien", Pasien.class).drop();
        database.getCollection("dokter", Dokter.class).drop();
        database.getCollection("rekamMedis", RekamMedis.class).drop();

        MongoCollection<Pasien> pasienMongoCollection = database.getCollection("pasien", Pasien.class);
        MongoCollection<Dokter> dokterMongoCollection = database.getCollection("dokter", Dokter.class);
        MongoCollection<RekamMedis> rekamMedisMongoCollection = database.getCollection("rekamMedis", RekamMedis.class);

        Pasien pasien1 = new Pasien(
                new ObjectId(),
                "passwordPasien",
                "NIM",
                "2023001",
                "Brucad Al Magribi",
                new Date(),
                "Laki-laki",
                "A+",
                new Kontak("ahmad@email.com", "08123", "Asrama Mahasiswa"),
                "Mahasiswa",
                new ProdiInfo(new ObjectId(), "Teknik Informatika"),
                new Date(),
                List.of("Debu"),
                List.of("Asma"),
                "Catatan khusus asma."
        );
        pasienMongoCollection.insertOne(pasien1);

        Pasien pasien2 = new Pasien(
                new ObjectId(),
                "passwordPasien",
                "NIM",
                "2023002",
                "Ahmad Brucad",
                new Date(),
                "Laki-laki",
                "B+",
                new Kontak("budi@email.com", "08456", "Asrama Dosen"),
                "Mahasiswa",
                new ProdiInfo(new ObjectId(), "Pendidikan Bahasa Arab"),
                new Date(),
                List.of("Udang"),
                List.of(),
                "Tidak ada riwayat alergi."
        );
        pasienMongoCollection.insertOne(pasien2);

        // Menambahkan Dokter
        Dokter dokter1 = new Dokter(
                new ObjectId(),
                "NIP001",
                "dr. Fulan",
                "Dokter Umum",
                "SIP12345",
                "123456",
                new Kontak("fulan.dr@unida.gontor.ac.id", "08900", "Poli Umum"),
                true
        );
        dokterMongoCollection.insertOne(dokter1);

        // Menambahkan Rekam Medis untuk Pasien Lama (pasien1)
        // Ini akan membuat pasien1 menjadi "Pasien Lama"
        RekamMedis rm1 = new RekamMedis(
                pasien1.getId(), pasien1.getNomorIdentitas(), pasien1.getNamaLengkap(), new Date(),
                "Pemeriksaan", "Batuk", "Anamnesa umum",
                new PemeriksaanFisik("120/80 mmHg", 38.5, "80 bpm", "18 bpm", 65, 170, "Konjungtiva anemis."),
                List.of(new Diagnosis("J06.9", "Infeksi Saluran Pernapasan Akut")),
                List.of(new TindakanMedis("Pemberian resep obat", "Edukasi pasien.")),
                List.of(new ResepObat(new ObjectId(), "Paracetamol", "500mg", 10, "Tablet", "3x1")),
                "Catatan dokter RM1", dokter1.getId(), dokter1.getNamaLengkap(), "Selesai", null, null
        );
        rekamMedisMongoCollection.insertOne(rm1);

        System.out.println("\nData awal untuk pengujian berhasil disiapkan.");
    }
}