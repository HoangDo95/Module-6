package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patientCode;

    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private Set<Medical> medicalSet;

    public Patient() {
    }

    public Patient(int id, String patientCode) {
        this.id = id;
        this.patientCode = patientCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public Set<Medical> getMedicalSet() {
        return medicalSet;
    }

    public void setMedicalSet(Set<Medical> medicalSet) {
        this.medicalSet = medicalSet;
    }
}
