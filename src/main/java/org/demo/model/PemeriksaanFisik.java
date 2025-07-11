package org.demo.model;

public class PemeriksaanFisik {
    private String tekananDarah;
    private double suhuTubuh;
    private String nadi;
    private String respirasi;
    private int beratBadan;
    private int tinggiBadan;
    private String catatanTambahan;

    public PemeriksaanFisik(){}
    public PemeriksaanFisik(String tekananDarah, double suhuTubuh, String nadi, String respirasi, int beratBadan, int tinggiBadan, String catatanTambahan){
        this.tekananDarah = tekananDarah;
        this.suhuTubuh = suhuTubuh;
        this.nadi = nadi;
        this.respirasi = respirasi;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.catatanTambahan = catatanTambahan;
    }
}
