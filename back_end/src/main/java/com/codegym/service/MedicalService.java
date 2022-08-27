package com.codegym.service;

import com.codegym.model.Medical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MedicalService {
    List<Medical> findAll();

    void save(Medical medical);

    Optional<Medical> findById(Integer id);

    void edit(Medical medical);

    void delete(Integer id);

    Page<Medical> findByName(String patientName, Pageable pageable);

}
