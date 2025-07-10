package org.demo;

public class DrugStock {
//public class MongoDBConnection {
//
//    public static void main(String[] args) {
//        // --- Bagian 1: Konfigurasi URI Koneksi ---
//        // Untuk MongoDB lokal:
//        String connectionString = "mongodb://localhost:27017";
//        // Jika Anda menggunakan MongoDB Atlas (Cloud), ganti dengan URI dari Atlas Anda:
//        // String connectionString = "mongodb+srv://<username>:<password>@<cluster-url>/<databaseName>?retryWrites=true&w=majority";
//
//        MongoClient mongoClient = null; // Deklarasikan di luar try agar bisa diakses di finally
//        try {
//            // --- Bagian 2: Membuat Koneksi ke MongoDB ---
//            // Menggunakan try-with-resources agar koneksi otomatis tertutup
//            // (tetapi dalam contoh ini kita mendeklarasikan di luar try untuk finally block)
//            mongoClient = MongoClients.create(connectionString);
//            System.out.println("Berhasil terhubung ke MongoDB!");
//
//            // --- Bagian 3: Mengakses Database ---
//            // Pilih atau buat database. Jika database belum ada, MongoDB akan membuatnya
//            // secara implisit saat Anda menyisipkan data pertama kali.
//            MongoDatabase database = mongoClient.getDatabase("perpusDatabase"); // Ganti dengan nama database Anda
//            System.out.println("Mengakses database: " + database.getName());
//
//            // --- Bagian 4: Mengakses Koleksi ---
//            // Pilih atau buat koleksi. Jika koleksi belum ada, MongoDB akan membuatnya
//            // secara implisit saat Anda menyisipkan data pertama kali.
//            MongoCollection<Document> collection = database.getCollection("bukuku"); // Ganti dengan nama koleksi Anda
//            System.out.println("Mengakses koleksi: " + collection.getNamespace().getCollectionName());
//
//            // --- Bagian 5: Menambahkan Data (Insert) ---
//            System.out.println("\n--- Menambahkan Dokumen ---");
//            Document buku1 = new Document("judul", "Belajar Java Lanjut")
//                    .append("pengarang", "Budi Doremi")
//                    .append("tahun_terbit", 2023)
//                    .append("tersedia", true);
//            InsertOneResult insertResult = collection.insertOne(buku1);
//            System.out.println("Dokumen buku 1 berhasil ditambahkan dengan ID: " + insertResult.getInsertedId());
//
//            Document buku2 = new Document("judul", "Panduan MongoDB Lengkap")
//                    .append("pengarang", "Siti Nurhaliza")
//                    .append("tahun_terbit", 2022)
//                    .append("tersedia", false)
//                    .append("tags", new String[]{"database", "nosql"}); // Contoh array field
//
//            InsertOneResult insertResult2 = collection.insertOne(buku2);
//            System.out.println("Dokumen buku 2 berhasil ditambahkan dengan ID: " + insertResult2.getInsertedId());
//
//
//            // --- Bagian 6: Membaca Data (Find) ---
//            System.out.println("\n--- Dokumen dalam Koleksi 'bukuku' ---");
//            // Cari semua dokumen
//            FindIterable<Document> allBooks = collection.find();
//            for (Document doc : allBooks) {
//                System.out.println(doc.toJson()); // Konversi dokumen BSON ke JSON string untuk dicetak
//            }
//
//            System.out.println("\n--- Mencari Dokumen dengan Kondisi ---");
//            // Cari dokumen yang 'tahun_terbit' > 2022
//            FindIterable<Document> newBooks = collection.find(new Document("tahun_terbit", new Document("$gt", 2022)));
//            for (Document doc : newBooks) {
//                System.out.println("Buku baru: " + doc.toJson());
//            }
//
//            // Cari satu dokumen berdasarkan judul
//            Document foundBook = collection.find(new Document("judul", "Panduan MongoDB Lengkap")).first();
//            if (foundBook != null) {
//                System.out.println("\nBuku ditemukan (single): " + foundBook.toJson());
//            } else {
//                System.out.println("\nBuku tidak ditemukan.");
//            }
//
//            // --- Bagian 7: Memperbarui Data (Update) ---
//            System.out.println("\n--- Memperbarui Dokumen ---");
//            // Perbarui dokumen dengan judul "Panduan MongoDB Lengkap"
//            // Set 'tersedia' menjadi true dan tambahkan field 'jumlah_halaman'
//            collection.updateOne(
//                    new Document("judul", "Panduan MongoDB Lengkap"),
//                    new Document("$set", new Document("tersedia", true).append("jumlah_halaman", 450))
//            );
//            System.out.println("Dokumen 'Panduan MongoDB Lengkap' berhasil diperbarui.");
//
//            // Verifikasi pembaruan
//            foundBook = collection.find(new Document("judul", "Panduan MongoDB Lengkap")).first();
//            if (foundBook != null) {
//                System.out.println("Setelah diperbarui: " + foundBook.toJson());
//            }
//
//            // --- Bagian 8: Menghapus Data (Delete) ---
//            System.out.println("\n--- Menghapus Dokumen ---");
//            DeleteResult deleteResult = collection.deleteOne(new Document("judul", "Belajar Java Lanjut"));
//            if (deleteResult.getDeletedCount() > 0) {
//                System.out.println("Dokumen 'Belajar Java Lanjut' berhasil dihapus.");
//            } else {
//                System.out.println("Dokumen tidak ditemukan untuk dihapus.");
//            }
//
//            // Verifikasi setelah penghapusan
//            System.out.println("\n--- Dokumen Tersisa Setelah Penghapusan ---");
//            FindIterable<Document> remainingBooks = collection.find();
//            for (Document doc : remainingBooks) {
//                System.out.println(doc.toJson());
//            }
//
//
//        } catch (MongoException e) {
//            System.err.println("Terjadi kesalahan MongoDB: " + e.getMessage());
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.err.println("Terjadi kesalahan umum: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            // --- Bagian 9: Menutup Koneksi ---
//            // Sangat penting untuk menutup koneksi ketika sudah tidak diperlukan
//            if (mongoClient != null) {
//                mongoClient.close();
//                System.out.println("\nKoneksi MongoDB ditutup.");
//            }
//        }
//    }
//}
}
