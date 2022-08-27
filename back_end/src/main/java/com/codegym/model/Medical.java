package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medicalCode;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id")
    private Patient patient;

    private String patientName;
    private String startDay;
    private String endDay;
    private String reason;
    private String treatments;
    private String doctor;

    public Medical() {
    }

    public Medical(int id, String medicalCode, Patient patient, String patientName, String startDay, String endDay, String reason, String treatments, String doctor) {
        this.id = id;
        this.medicalCode = medicalCode;
        this.patient = patient;
        this.patientName = patientName;
        this.startDay = startDay;
        this.endDay = endDay;
        this.reason = reason;
        this.treatments = treatments;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
