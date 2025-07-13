package com.example.fisioapp.repositories;

import com.example.fisioapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.cpf = :cpf")
    Optional<Patient> findByCpf(@Param("cpf") String cpf);

}
