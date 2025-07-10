package org.demo.database;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
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

            // to read your Document
            System.out.println("\n--- Dokumen Dalam Koleksi " + collection.getNamespace() + " ---");
            // look all doc.
            FindIterable<Document> allDrug = collection.find();
            for (Document doc : allDrug) {
                System.out.println(doc.toJson());
            }

//            // Update Data
//            System.out.println("\n --- Memperbarui Dokumen ---");
//            collection.updateOne(
//                    new Document("namaObat", "Infinix"),
//                    new Document("kekuatan", "200mg")
//            );

//            Delete Data
            System.out.println("\n --- Menghapus Data ---");
            DeleteResult deleteResult = collection.deleteOne(new Document("nama", "Brucad"));

            if (deleteResult.getDeletedCount() > 0) {
                System.out.println("Dokumen 'Paracetamol' berhasil dihapus");
            } else {
                System.out.println("Dokumen tidak ditemukan untuk dihapus");
            }

//            Update after Delete
            System.out.println("\n --- Dokumen Tersisa setelah Penghapusan");
            FindIterable<Document> remainingDrug = collection.find();
            for (Document doc2 : remainingDrug) {
                System.out.println(doc2);
            }
        } catch (MongoException e) {
            System.err.println("Terjadi Kesalahan MongoDb : " + e.getMessage());
            e.printStackTrace();
        }
    }
}


