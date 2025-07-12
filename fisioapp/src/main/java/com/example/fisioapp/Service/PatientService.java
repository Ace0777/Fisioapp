package com.example.fisioapp.Service;

import java.util.List;
import java.util.Optional;


import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.BrasilApiCepResponse;
import com.example.fisioapp.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private CepService cepService;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient save(Patient patient) {
        boolean existsCpf = false;

        Optional<Patient> optPatient = patientRepository.findByCpf(patient.getCpf());

        if (optPatient.isPresent()) {
            if (!optPatient.get().getId().equals(patient.getId())) {
                existsCpf = true;
            }
        }

        if (existsCpf) throw new RuntimeException("CPF já cadastrado!");

        if (!cepService.validaCep((patient.getCep()))) throw new IllegalArgumentException("CEP inválido.");

        return patientRepository.save(patient);
    }

    public void delete(Long id){
        patientRepository.deleteById(id);
    }
}