package org.demo.model;

public class TindakanMedis {
    private String namaTindakan;
    private String catatan;

    public TindakanMedis(){}
    public TindakanMedis(String namaTindakan, String catatan){
        this.namaTindakan = namaTindakan;
        this.catatan = catatan;
    }

    public String getNamaTindakan(){return namaTindakan;}
    public void setNamaTindakan(String namaTindakan){this.namaTindakan = namaTindakan;}

    public String getCatatan(){return catatan;}
    public void setCatatan(String catatan){this.catatan = catatan;}
}
