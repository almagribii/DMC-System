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
    public Dokter(ObjectId id, String nipPegawai, String namaLengkap, String spesialisasi, String nomorSIP, Kontak kontak, boolean statusAktif){
        this.id = id;
        this.nipPegawai = nipPegawai;
        this.namaLengkap = namaLengkap;
        this.spesialisasi = spesialisasi;
        this.nomorSIP = nomorSIP;
        this.kontak = kontak;
        this.statusAktif = statusAktif;
    }
}
