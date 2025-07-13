package org.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Dokter {
    @Id
    private String  id;
    private String passwordHash;
    private String nipPegawai;
    private String namaLengkap;
    private String spesialisasi;
    private String nomorSIP;
    private Kontak kontak; // Re-use Kontak class
    private boolean statusAktif;

    public Dokter () {}
    public Dokter(String  id,
                  String passwordHash,
                  String nipPegawai,
                  String namaLengkap,
                  String spesialisasi,
                  String nomorSIP,
                  Kontak kontak,
                  boolean statusAktif
    ){
        this.id = id;
        this.passwordHash = passwordHash;
        this.nipPegawai = nipPegawai;
        this.namaLengkap = namaLengkap;
        this.spesialisasi = spesialisasi;
        this.nomorSIP = nomorSIP;
        this.kontak = kontak;
        this.statusAktif = statusAktif;
    }

    public String getId () {return id;}
    public void setId (String  id) {this.id = id; }

    public String getPasswordHash(){return passwordHash;}
    public void setPasswordHash(String passwordHash){this.passwordHash = passwordHash;}

    public String getNipPegawai(){return nipPegawai;}
    public void setNipPegawai(String nipPegawai){this.nipPegawai = nipPegawai;}

    public String getNamaLengkap() {return namaLengkap;}
    public void setNamaLengkap(String namaLengkap){this.namaLengkap = namaLengkap;}

    public String getSpesialisasi(){return spesialisasi;}
    public void setSpesialisasi(String spesialisasi){this.spesialisasi = spesialisasi;}

    public String getNomorSIP(){return nomorSIP;}
    public void setNomorSIP(String nipPegawai){this.nomorSIP = nomorSIP;}

    public Kontak getKontak(){return kontak;}
    public void setKontak(Kontak kontak){this.kontak = kontak;}

    public boolean isStatusAktif(){return statusAktif;}
    public void setStatusAktif(boolean statusAktif){this.statusAktif = statusAktif;}
}
