package com.example.fisioapp.controller;


import com.example.fisioapp.Service.PatientService;
import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.PatientDTO;
import com.example.fisioapp.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    public void savePatient(PatientDTO dto) {
        Patient patient = PatientMapper.INSTANCE.toEntity(dto);
        patientService.save(patient);
    }

    public List<Patient> findAllPatient(){
        return patientService.findAll();
    }

    public Optional<Patient> findPatientById(Long id){
        return patientService.findById(id);
    }

    public Patient updatePatient(Long id, PatientDTO dto) {
         return patientService.updatePatient(id, dto);
    }

    public void delete(Long id){
        patientService.deletePatient(id);
    }

}
