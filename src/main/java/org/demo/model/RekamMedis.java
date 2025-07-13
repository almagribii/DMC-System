package org.demo.model;


import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class RekamMedis {
    @Id
    private String id;
    private String idPasien; // Reference to Pasien
    private String nomorIdentitasPasien; // Denormalized
    private String namaPasien;           // Denormalized
    private Date tanggalKunjungan;
    private String jenisKunjungan;
    private String keluhanUtama;
    private String anamnesa;
    private PemeriksaanFisik pemeriksaanFisik; // Embedded Document
    private List<Diagnosis> diagnosis;         // Array of Embedded Documents
    private List<TindakanMedis> tindakanMedis; // Array of Embedded Documents
    private List<ResepObat> resepObat;         // Array of Embedded Documents
    private String catatanDokter;
    private String idDokterPenanggungJawab; // Reference to Dokter
    private String namaDokterPenanggungJawab; // Denormalized
    private String statusKunjungan;
    private Date tanggalBerikutnya;
    private List<LampiranFile> fileLampiran; // Array of Embedded Documents

    // --- Constructors, Getters, and Setters ---
    // (Generate these in your IDE for all fields)
    public RekamMedis() {}

    public RekamMedis(String idPasien, String nomorIdentitasPasien, String namaPasien, Date tanggalKunjungan, String jenisKunjungan, String keluhanUtama, String anamnesa, PemeriksaanFisik pemeriksaanFisik, List<Diagnosis> diagnosis, List<TindakanMedis> tindakanMedis, List<ResepObat> resepObat, String catatanDokter, String idDokterPenanggungJawab, String namaDokterPenanggungJawab, String statusKunjungan, Date tanggalBerikutnya, List<LampiranFile> fileLampiran) {
        this.idPasien = idPasien;
        this.nomorIdentitasPasien = nomorIdentitasPasien;
        this.namaPasien = namaPasien;
        this.tanggalKunjungan = tanggalKunjungan;
        this.jenisKunjungan = jenisKunjungan;
        this.keluhanUtama = keluhanUtama;
        this.anamnesa = anamnesa;
        this.pemeriksaanFisik = pemeriksaanFisik;
        this.diagnosis = diagnosis;
        this.tindakanMedis = tindakanMedis;
        this.resepObat = resepObat;
        this.catatanDokter = catatanDokter;
        this.idDokterPenanggungJawab = idDokterPenanggungJawab;
        this.namaDokterPenanggungJawab = namaDokterPenanggungJawab;
        this.statusKunjungan = statusKunjungan;
        this.tanggalBerikutnya = tanggalBerikutnya;
        this.fileLampiran = fileLampiran;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    // ... all other getters and setters
    public String getIdPasien() { return idPasien; }
    public void setIdPasien(String idPasien) { this.idPasien = idPasien; }
    // ...
}