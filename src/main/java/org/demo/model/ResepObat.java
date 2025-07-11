package org.demo.model;

import org.bson.types.ObjectId;

public class ResepObat {
    private ObjectId idObat;
    private String namaObat;
    private String kekuatan;
    private int jumlah;
    private String satuan;
    private String aturanPakai;

    public ResepObat() {
    }

    public ResepObat(ObjectId idObat,
                     String namaObat,
                     String kekuatan,
                     int jumlah,
                     String satuan,
                     String aturanPakai) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.kekuatan = kekuatan;
        this.jumlah = jumlah;
        this.satuan = satuan;
        this.aturanPakai = aturanPakai;
    }
    public ObjectId getIdObat(){return idObat;}
    public void setIdObat(ObjectId idObat){this.idObat = idObat;}

    public String getNamaObat(){return namaObat;}
    public void setNamaObat(String namaObat){this.namaObat = namaObat;}

    public String getKekuatan(){return kekuatan;}
    public void setKekuatan(String kekuatan){this.kekuatan = kekuatan;}

    public int getJumlah(){return jumlah;}
    public void setJumlah(int jumlah){ this.jumlah = jumlah;}

    public String getSatuan(){return satuan;}
    public void setSatuan(String satuan){this.satuan = satuan;}

    public String getAturanPakai(){return aturanPakai;}
    public void setAturanPakai(String aturanPakai){this.aturanPakai = aturanPakai;}
}
