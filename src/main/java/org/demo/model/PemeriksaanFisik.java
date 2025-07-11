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

    public String getTekananDarah(){return tekananDarah;}
    public void setTekananDarah(String tekananDarah){this.tekananDarah = tekananDarah;}

    public double getSuhuTubuh(){return suhuTubuh;}
    public void setSuhuTubuh(double suhuTubuh){this.suhuTubuh = suhuTubuh;}

    public String getNadi(){return nadi;}
    public void setNadi(String nadi){this.nadi = nadi;}

    public String getRespirasi(){return respirasi;}
    public void setRespirasi(String respirasi){this.respirasi = respirasi;}

    public int getBeratBadan(){return beratBadan;}
    public void setBeratBadan(int beratBadan){this.beratBadan = beratBadan;}

    public int getTinggiBadan(){return tinggiBadan;}
    public void setTinggiBadan(int tinggiBadan){this.tinggiBadan = tinggiBadan;}

    public String getCatatanTambahan(){return catatanTambahan;}
    public void setCatatanTambahan(String catatanTambahan){this.catatanTambahan = catatanTambahan;}
}
