package com.codegym.repository;

import com.codegym.model.Medical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface MedicalRepository extends JpaRepository<Medical, Integer> {
    @Query(value = "select * from medical", nativeQuery = true)
    List<Medical> medicalList();

    @Modifying
    @Query(value = "insert into medical ( doctor, end_day, medical_code, patient_name, reason, start_day, treatments, id_patient)" +
            "values (:doctor, :endDay, :medicalCode, :patientName, :reason, :starDay, :treatments, :patient)", nativeQuery = true)
    void save(@Param("doctor") String doctor, @Param("endDay") String endDay, @Param("medicalCode") String medicalCode, @Param("patientName") String patientName,
              @Param("reason") String reason, @Param("starDay") String starDay, @Param("treatments") String treatments, @Param("patient") int patient);

    @Query(value = "select * from medical where id = :id", nativeQuery = true)
    Optional<Medical> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update medical set doctor = :doctor, set end_day =: endDay,set medical_code =: medicalCode,set patient_name =: patientName ,set reason =: reason, set start_day =: startDay ,set treatments =: treatments,set id_patient =: patient where id =: id", nativeQuery = true)
    void update(@Param("doctor") String doctor, @Param("endDay") String endDay, @Param("medicalCode") String medicalCode, @Param("patientName") String patientName, @Param("reason") String reason, @Param("start_day") String startDay, @Param("treatments") String treatments, @Param("patient") int patient, @Param("id") int id);
//    @Query(value = "update medical set doctor = :doctor,set reason =: reason,set treatments =: treatments where id =:id", nativeQuery = true)
//    void update(@Param("doctor") String doctor, @Param("reason") String reason, @Param("treatments") String treatments, @Param("id") int id);

    @Query(value = "delete from medical where id =: id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value = "select * from  where patient_name =:patientName", nativeQuery = true)
    Page<Medical> findByName(@Param("patientName") String patientName, Pageable pageable);
}
