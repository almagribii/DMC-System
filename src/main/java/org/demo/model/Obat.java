package org.demo.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Obat {
    private ObjectId id;
    private String namaObat;
    private String namaMerek;
    private String bentukSediaan;
    private String kekuatan;
    private String satuanKekuatan;
    private List<String> kandunganAktif;
    private String golonganObat;
    private String produsen;
    private String nomorIzinEdar;
    private Date kadaluarsa;
    private double hargaJual; // Use double for currency
    private String satuanKemasan;
    private int jumlahPerKemasan;
    private int stokTersedia;

    public Obat () {}

    public Obat (ObjectId id,
                 String namaObat,
                 String namaMerek,
                 String bentukSediaan,
                 String kekuatan,
                 String satuanKekuatan,
                 List kandunganAktif,
                 String golonganObat,
                 String produsen,
                 String nomorIzinEdar,
                 Date kadaluarsa,
                 double hargaJual,
                 String satuanKemasan,
                 int jumlahPerKemasan,
                 int stokTersedia){
        this.id = id;
        this.namaObat = namaObat;
        this.namaMerek = namaMerek;
        this.bentukSediaan = bentukSediaan;
        this.kekuatan = kekuatan;
        this.satuanKekuatan = satuanKekuatan;
        this.kandunganAktif = kandunganAktif;
        this.golonganObat = golonganObat;
        this.produsen = produsen;
        this.nomorIzinEdar = nomorIzinEdar;
        this.kadaluarsa = kadaluarsa;
        this.hargaJual = hargaJual;
        this.satuanKemasan = satuanKemasan;
        this.jumlahPerKemasan = jumlahPerKemasan;
        this.stokTersedia = stokTersedia;
    }
    public ObjectId getId() {
        return id;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public String getNamaMerek() {
        return namaMerek;
    }

    public String getBentukSediaan() {
        return bentukSediaan;
    }

    public String getKekuatan() {
        return kekuatan;
    }

    public String getSatuanKekuatan() {
        return satuanKekuatan;
    }

    public List<String> getKandunganAktif() {
        return kandunganAktif;
    }

    public String getGolonganObat() {
        return golonganObat;
    }

    public String getProdusen() {
        return produsen;
    }

    public String getNomorIzinEdar() {
        return nomorIzinEdar;
    }

    public Date getKadaluarsa() {
        return kadaluarsa;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public String getSatuanKemasan() {
        return satuanKemasan;
    }

    public int getJumlahPerKemasan() {
        return jumlahPerKemasan;
    }

    public int getStokTersedia() {
        return stokTersedia;
    }


    // --- SETTERS ---
    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setNamaMerek(String namaMerek) {
        this.namaMerek = namaMerek;
    }

    public void setBentukSediaan(String bentukSediaan) {
        this.bentukSediaan = bentukSediaan;
    }

    public void setKekuatan(String kekuatan) {
        this.kekuatan = kekuatan;
    }

    public void setSatuanKekuatan(String satuanKekuatan) {
        this.satuanKekuatan = satuanKekuatan;
    }

    public void setKandunganAktif(List<String> kandunganAktif) {
        this.kandunganAktif = kandunganAktif;
    }

    public void setGolonganObat(String golonganObat) {
        this.golonganObat = golonganObat;
    }

    public void setProdusen(String produsen) {
        this.produsen = produsen;
    }

    public void setNomorIzinEdar(String nomorIzinEdar) {
        this.nomorIzinEdar = nomorIzinEdar;
    }

    public void setKadaluarsa(Date kadaluarsa) {
        this.kadaluarsa = kadaluarsa;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public void setSatuanKemasan(String satuanKemasan) {
        this.satuanKemasan = satuanKemasan;
    }

    public void setJumlahPerKemasan(int jumlahPerKemasan) {
        this.jumlahPerKemasan = jumlahPerKemasan;
    }

    public void setStokTersedia(int stokTersedia) {
        this.stokTersedia = stokTersedia;
    }
}
