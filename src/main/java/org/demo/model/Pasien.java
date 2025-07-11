package org.demo.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Pasien {
    private ObjectId id;
    private String jenisIdentitas;
    private String nomorIdentitas;
    private String namaLengkap;
    private Date tanggalLahir;
    private String jenisKelamin;
    private String golonganDarah;
    private Kontak kontak;
    private String statusCivitas;
    private ProdiInfo programStudi;
    private Date tanggalDaftarDMC;
    private List<String> riwayatAlergi;
    private List<String> riwayatPenyakitKronis;
    private String catatanTambahan;

    public Pasien() {
    }

    public Pasien(ObjectId id,
                  String jenisIdentitas,
                  String nomorIdentitas,
                  String namaLengkap,
                  Date tanggalLahir,
                  String jenisKelamin,
                  String golonganDarah,
                  Kontak kontak,
                  String statusCivitas,
                  ProdiInfo programStudi,
                  Date tanggalDaftarDMC,
                  List riwayatAlergi,
                  List riwayatPenyakitKronis,
                  String catatanTambahan) {
        this.id = id;
        this.jenisIdentitas = jenisIdentitas;
        this.nomorIdentitas = nomorIdentitas;
        this.namaLengkap = namaLengkap;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
        this.kontak = kontak;
        this.statusCivitas = statusCivitas;
        this.programStudi = programStudi;
        this.tanggalDaftarDMC = tanggalDaftarDMC;
        this.riwayatAlergi = riwayatAlergi;
        this.riwayatPenyakitKronis = riwayatPenyakitKronis;
        this.catatanTambahan = catatanTambahan;
    }

    public ObjectId getId(){return id;};
    public void setId(ObjectId id){this.id = id;}
}
