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
    }
}
