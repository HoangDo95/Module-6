package com.codegym.service;

import com.codegym.model.Patient;
import com.codegym.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.patientList();
    }
}
