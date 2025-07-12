package org.demo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider; // Ini penting!
import org.bson.Document; // Tetap perlu untuk query

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Handle { // Ubah nama kelas menjadi sesuatu yang lebih sesuai, misal DmcApp
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017"; // Atau URI MongoDB Atlas Anda

        // --- Konfigurasi CodecRegistry untuk POJO Mapping ---
        // 1. Buat PojoCodecProvider: Ini adalah bagian yang memberitahu driver bahwa kita ingin mapping otomatis
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();

        // 2. Gabungkan dengan CodecRegistry default MongoDB
        // Ini memastikan driver juga bisa menangani tipe dasar seperti String, Integer, ObjectId, dll.
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(pojoCodecProvider) // Tambahkan provider POJO kita
        );

        MongoClient mongoClient = null;
        try {
            // 3. Bangun MongoClientSettings dengan CodecRegistry yang sudah dikonfigurasi
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(connectionString))
                    .codecRegistry(pojoCodecRegistry) // Daftarkan registry POJO di sini
                    .build();

            // 4. Buat MongoClient menggunakan settings tersebut
            mongoClient = MongoClients.create(settings);

            MongoDatabase database = mongoClient.getDatabase("dmcUnidaDB"); // Nama database Anda
            System.out.println("Berhasil terhubung ke database: " + database.getName());

            // ... Selanjutnya kita akan mulai menggunakan koleksi dengan POJO ...

        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat koneksi atau operasi MongoDB: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
                System.out.println("Koneksi MongoDB ditutup.");
            }
        }
    }
}