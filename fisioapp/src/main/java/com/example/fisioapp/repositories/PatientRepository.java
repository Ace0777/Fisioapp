package com.example.fisioapp.repositories;

import com.example.fisioapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
