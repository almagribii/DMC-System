package org.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ProdiInfo {
    @Id
    private String  idProdi;
    private String namaProdi;

    public ProdiInfo(){}

    public ProdiInfo(String  idProdi, String namaProdi){
        this.idProdi = idProdi;
        this.namaProdi = namaProdi;
    }

    public String  getIdProdi(){return idProdi;}
    public void setIdProdi(String  idProdi){this.idProdi = idProdi;}

    public String getNamaProdi(){return namaProdi;}
    public void setNamaProdi(String namaProdi){this.namaProdi = namaProdi;}
}

