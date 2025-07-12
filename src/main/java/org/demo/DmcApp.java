package org.demo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.demo.model.Pasien;

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
        try {
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(connectionString))
                    .codecRegistry(codecRegistry)
                    .build();

            mongoClient = MongoClients.create(settings);

            MongoDatabase database = mongoClient.getDatabase("DMC");
            System.out.println("Berhasil Terhubung ke database: " + database.getName());


        } catch (Exception e){
            System.out.println("Terjadi kesalahan saat koneksi atau operasi MongoDB: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (mongoClient != null){
                mongoClient.close();
                System.out.println("Koneksi MongoDb ditutup");
            }
        }
    }
}