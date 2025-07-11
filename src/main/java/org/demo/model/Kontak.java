package org.demo.model;

public class Kontak {
    private String email;
    private String telepon;
    private String alamat;

    public Kontak(){}

    public Kontak(String email, String telepon, String alamat){
        this.email = email;
        this.telepon = telepon;
        this.alamat = alamat;
    }
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getTelepon(){return telepon;}
    public void  setTelepon(String telepon){this.telepon = telepon;}

    public String getAlamat(){return alamat;}
    public void setAlamat (String alamat){this.alamat = alamat;}
}
