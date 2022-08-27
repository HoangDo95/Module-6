package com.codegym.repository;

import com.codegym.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> patientList();
}
