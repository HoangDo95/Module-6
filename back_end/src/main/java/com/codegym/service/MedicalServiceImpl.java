package com.codegym.service;

import com.codegym.model.Medical;
import com.codegym.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalServiceImpl implements MedicalService {
    @Autowired
    MedicalRepository medicalRepository;

    @Override
    public List<Medical> findAll() {
        return medicalRepository.medicalList();
    }

    @Override
    public void save(Medical medical) {
        medicalRepository.save(medical);
    }

    public Optional<Medical> findById(Integer id) {
        return medicalRepository.findById(id);
    }

    @Override
    public void edit(Medical medical) {
        medicalRepository.update(medical.getDoctor(),medical.getEndDay() ,medical.getPatientName()
                ,medical.getPatientName(),medical.getReason(),medical.getStartDay(),medical.getTreatments()
                ,medical.getPatient().getId() ,medical.getId());
    }

    @Override
    public void delete(Integer id) {
        medicalRepository.deleteById(id);
    }

    @Override
    public Page<Medical> findByName(String patientName, Pageable pageable) {
        return medicalRepository.findByName(patientName, pageable);
    }
}
