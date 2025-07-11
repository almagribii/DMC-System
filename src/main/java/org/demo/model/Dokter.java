package org.demo.model;

import org.bson.types.ObjectId;

public class Dokter {
    private ObjectId id;
    private String nipPegawai;
    private String namaLengkap;
    private String spesialisasi;
    private String nomorSIP;
    private Kontak kontak; // Re-use Kontak class
    private boolean statusAktif;

    public Dokter () {}
    public Dokter(ObjectId id,
                  String nipPegawai,
                  String namaLengkap,
                  String spesialisasi,
                  String nomorSIP,
                  Kontak kontak,
                  boolean statusAktif
    ){
        this.id = id;
        this.nipPegawai = nipPegawai;
        this.namaLengkap = namaLengkap;
        this.spesialisasi = spesialisasi;
        this.nomorSIP = nomorSIP;
        this.kontak = kontak;
        this.statusAktif = statusAktif;
    }

    public ObjectId getId () {return id;}
    public void setId (ObjectId id) {this.id = id; }

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
