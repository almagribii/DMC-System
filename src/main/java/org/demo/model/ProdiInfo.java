package org.demo.model;

import org.bson.types.ObjectId;

public class ProdiInfo {
    private ObjectId idProdi;
    private String namaProdi;

    public ProdiInfo(){}

    public ProdiInfo(ObjectId idProdi, String namaProdi){
        this.idProdi = idProdi;
        this.namaProdi = namaProdi;
    }
}

