package org.demo.database;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;


public class MongoDBConnection {
    public static void main(String[] args) {
        // Configuration URL --> Connect to local Mongo     Different if you use Mongo from Atlas
        String connectionString = "mongodb://localhost:27017";
        // Deklaration from outside try so that be acces in finally
        MongoClient mongoClient = null;

        try {
            // Connect To MongoDb
            mongoClient = MongoClients.create(connectionString);
            System.out.println("Apliksi Berhasil Terhubung ke MongoDb");

            // Connect To Database On Mongo
            MongoDatabase database = mongoClient.getDatabase("DMC");
            System.out.println("Mengakses Databases:" + database.getName());

            // MongoCollection collection2 = mongoClient.getDatabase("").getCollection("");
            //Connect To Collection
            MongoCollection<Document> collection  = database.getCollection("DrugStock");
            System.out.println("Mengakses Koleksi " + collection.getNamespace().getCollectionName());

            System.out.println("\n--- Menambahkan Dokumen ---");
            Document obat1 = new Document ("namaObat", "Parecetamol")
                    .append("bentukSediaan", "Tablet")
                    .append("kekuatan", "100mg");
            InsertOneResult insertOneResult = collection.insertOne(obat1);
            System.out.println("Dokumen buku 1 berhasil ditambahkan dengan ID" + insertOneResult.getInsertedId());

        } catch (MongoException e) {
            System.err.println("Terjadi Kesalahan MongoDb : " + e.getMessage());
            e.printStackTrace();
        }
    }
}


