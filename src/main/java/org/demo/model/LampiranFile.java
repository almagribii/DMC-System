package org.demo.model;

public class LampiranFile {
    private String namaFile;
    private String url;

    public LampiranFile(){}
    public LampiranFile(String namaFile, String url){
        this.namaFile = namaFile;
        this.url = url;
    }

    public String getNamaFile(){return namaFile;}
    public void setNamaFile(String namaFile){this.namaFile = namaFile;}

    public String getUrl(){return url;}
    public void setUrl(String url){this.url = url;}
}
