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

    public String getJenisIdentitas(){return jenisIdentitas;}
    public void setJenisIdentitas(String jenisIdentitas){this.jenisIdentitas = jenisIdentitas;}

    public String getNomorIdentitas(){return nomorIdentitas;}
    public void setNomorIdentitas(String nomorIdentitas){this.nomorIdentitas = nomorIdentitas;}

    public String getNamaLengkap(){return namaLengkap;}
    public void setNamaLengkap(String namaLengkap){this.namaLengkap = namaLengkap;}

    public Date getTanggalLahir(){return tanggalLahir;}
    public void setTanggalLahir(Date tanggalLahir){this.tanggalLahir = tanggalLahir;}

    public String getJenisKelamin(){return jenisKelamin;}
    public void setJenisKelamin(String jenisKelamin){this.jenisKelamin = jenisKelamin;}

    public String getGolonganDarah(){return golonganDarah;}
    public void setGolonganDarah(String golonganDarah){this.golonganDarah = golonganDarah;}

    public Kontak getKontak(){return kontak;}
    public void setKontak(Kontak kontak){this.kontak = kontak;}

    public String getStatusCivitas(){return statusCivitas;}
    public void setStatusCivitas(String statusCivitas){this.statusCivitas = statusCivitas;}

    public ProdiInfo getProgramStudi(){return programStudi;}
    public void setProgramStudi(ProdiInfo programStudi){this.programStudi = programStudi;}

    public Date getTanggalDaftarDMC(){return tanggalDaftarDMC;}
    public void setTanggalDaftarDMC(Date tanggalDaftarDMC){this.tanggalDaftarDMC = tanggalDaftarDMC;}

    public List<String> getRiwayatAlergi(){return riwayatAlergi;}
    public void setRiwayatAlergi(List<String> riwayatAlergi){this.riwayatAlergi = riwayatAlergi;}

    public List<String> getRiwayatPenyakitKronis(){return riwayatPenyakitKronis;}
    public void setRiwayatPenyakitKronis(List<String> riwayatPenyakitKronis){this.riwayatPenyakitKronis = riwayatPenyakitKronis;}

    public String getCatatanTambahan(){return catatanTambahan;}
    public void setCatatanTambahan(String catatanTambahan){this.catatanTambahan =  catatanTambahan;}
}
