package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.model.Patient;
import com.codegym.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/patient")
public class PatientRestController {
    @Autowired
    PatientService patientService;

    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getPatientList() {
        List<Patient> patientList = patientService.findAll();
        if (patientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

}
