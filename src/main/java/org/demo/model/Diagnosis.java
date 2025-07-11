package org.demo.model;

public class Diagnosis {
    private String kodeICD;
    private String namaDiagnosis;

    public Diagnosis(){}
    public Diagnosis(String kodeICD, String namaDiagnosis){
        this.kodeICD = kodeICD;
        this.namaDiagnosis = namaDiagnosis;
    }
}
