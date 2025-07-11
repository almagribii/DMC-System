package org.demo.model;

public class Diagnosis {
    private String kodeICD;
    private String namaDiagnosis;

    public Diagnosis(){}
    public Diagnosis(String kodeICD, String namaDiagnosis){
        this.kodeICD = kodeICD;
        this.namaDiagnosis = namaDiagnosis;
    }

    public String getKodeICD(){return kodeICD;}
    public void setKodeICD(String kodeICD){this.kodeICD = kodeICD;}

    public String getNamaDiagnosis(){return namaDiagnosis;}
    public void setNamaDiagnosis(String namaDiagnosis){this.namaDiagnosis = namaDiagnosis;}
}
