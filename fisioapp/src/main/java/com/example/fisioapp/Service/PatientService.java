package com.example.fisioapp.Service;

import java.util.List;


import com.example.fisioapp.model.Patient;
import com.example.fisioapp.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado: " + id));
    }

}