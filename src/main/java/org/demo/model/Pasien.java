package org.demo.model;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class Pasien {
    private ObjectId id;
    private String passwordHash;
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
        // Konstruktor default tanpa argumen (penting untuk POJO mapping)
    }

    // Konstruktor dengan semua atribut
    public Pasien(ObjectId id,
                  String passwordHash,
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
                  List<String> riwayatAlergi,       // <--- PERBAIKAN: Tambahkan <String> di sini
                  List<String> riwayatPenyakitKronis, // <--- PERBAIKAN: Tambahkan <String> di sini
                  String catatanTambahan) {
        this.id = id;
        this.passwordHash = passwordHash;
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

    // --- GETTERS ---
    public ObjectId getId(){return id;}
    public String getPasswordHash(){return passwordHash;}
    public String getJenisIdentitas(){return jenisIdentitas;}
    public String getNomorIdentitas(){return nomorIdentitas;}
    public String getNamaLengkap(){return namaLengkap;}
    public Date getTanggalLahir(){return tanggalLahir;}
    public String getJenisKelamin(){return jenisKelamin;}
    public String getGolonganDarah(){return golonganDarah;}
    public Kontak getKontak(){return kontak;}
    public String getStatusCivitas(){return statusCivitas;}
    public ProdiInfo getProgramStudi(){return programStudi;}
    public Date getTanggalDaftarDMC(){return tanggalDaftarDMC;}
    public List<String> getRiwayatAlergi(){return riwayatAlergi;}
    public List<String> getRiwayatPenyakitKronis(){return riwayatPenyakitKronis;}
    public String getCatatanTambahan(){return catatanTambahan;}

    // --- SETTERS ---
    public void setId(ObjectId id){this.id = id;}
    public void setPasswordHash(String passwordHash){this.passwordHash = passwordHash;}
    public void setJenisIdentitas(String jenisIdentitas){this.jenisIdentitas = jenisIdentitas;}
    public void setNomorIdentitas(String nomorIdentitas){this.nomorIdentitas = nomorIdentitas;}
    public void setNamaLengkap(String namaLengkap){this.namaLengkap = namaLengkap;}
    public void setTanggalLahir(Date tanggalLahir){this.tanggalLahir = tanggalLahir;}
    public void setJenisKelamin(String jenisKelamin){this.jenisKelamin = jenisKelamin;}
    public void setGolonganDarah(String golonganDarah){this.golonganDarah = golonganDarah;}
    public void setKontak(Kontak kontak){this.kontak = kontak;}
    public void setStatusCivitas(String statusCivitas){this.statusCivitas = statusCivitas;}
    public void setProgramStudi(ProdiInfo programStudi){this.programStudi = programStudi;}
    public void setTanggalDaftarDMC(Date tanggalDaftarDMC){this.tanggalDaftarDMC = tanggalDaftarDMC;}
    public void setRiwayatAlergi(List<String> riwayatAlergi){this.riwayatAlergi = riwayatAlergi;}
    public void setRiwayatPenyakitKronis(List<String> riwayatPenyakitKronis){this.riwayatPenyakitKronis = riwayatPenyakitKronis;}
    public void setCatatanTambahan(String catatanTambahan){this.catatanTambahan =  catatanTambahan;}

    @Override
    public String toString() {
        return "Pasien{" +
                "id=" + id +
                ", passwordHash='" + "[PROTECTED]" + '\'' + // Jangan tampilkan password di toString
                ", jenisIdentitas='" + jenisIdentitas + '\'' +
                ", nomorIdentitas='" + nomorIdentitas + '\'' +
                ", namaLengkap='" + namaLengkap + '\'' +
                ", tanggalLahir=" + tanggalLahir +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", golonganDarah='" + golonganDarah + '\'' +
                ", kontak=" + kontak +
                ", statusCivitas='" + statusCivitas + '\'' +
                ", programStudi=" + programStudi +
                ", tanggalDaftarDMC=" + tanggalDaftarDMC +
                ", riwayatAlergi=" + riwayatAlergi +
                ", riwayatPenyakitKronis=" + riwayatPenyakitKronis +
                ", catatanTambahan='" + catatanTambahan + '\'' +
                '}';
    }
}