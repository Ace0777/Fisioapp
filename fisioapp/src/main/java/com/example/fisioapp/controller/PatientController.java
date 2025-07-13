package com.example.fisioapp.controller;

import com.example.fisioapp.service.PatientService;
import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.PatientDTO;
import com.example.fisioapp.mapper.PatientMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping
    public Patient savePatient(@RequestBody @Valid PatientDTO dto) {
        Patient patient = PatientMapper.INSTANCE.toEntity(dto);
        return patientService.save(patient);
    }

    @GetMapping
    public List<Patient> findAllPatient(){
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id){
        return patientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody @Valid PatientDTO dto) {
        return patientService.updatePatient(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}

