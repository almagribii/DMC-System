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
    public ObjectId getId  () { return id;}
    public void setId(ObjectId id) {this.id = id;}
}
