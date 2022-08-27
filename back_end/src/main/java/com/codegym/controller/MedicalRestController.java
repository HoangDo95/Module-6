package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.model.Patient;
import com.codegym.service.MedicalService;
import com.codegym.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/medical")
public class MedicalRestController {

    @Autowired
    MedicalService medicalService;

    @GetMapping("/list")
    public ResponseEntity <List<Medical>> getMedicalList() {
        List<Medical> medicalList = medicalService.findAll();
        if (medicalList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity <Medical> createMedical(@RequestBody Medical medical) {
       medicalService.save(medical);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("find/{id}")
    public ResponseEntity <Optional<Medical>> findById(@PathVariable("id") Integer id) {
        Optional<Medical> medical = medicalService.findById(id);
        if (!medical.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity <Medical> updateMedical(@RequestBody Medical medical) {
        medicalService.edit(medical);
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Optional<Medical>> deleteMedical(@PathVariable("id") Integer id) {
        Optional<Medical> medical = medicalService.findById(id);
        if (!medical.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicalService.delete(id);
        return new ResponseEntity<>(medical, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Medical>> findByName(@RequestParam String patientName,
                                                    @PageableDefault(value = 3)Pageable pageable){
        Page<Medical> medicalPage = medicalService.findByName(patientName, pageable);
        return new ResponseEntity<>(medicalPage, HttpStatus.OK);
    }



}
