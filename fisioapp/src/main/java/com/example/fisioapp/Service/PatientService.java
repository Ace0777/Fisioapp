package com.example.fisioapp.Service;

import java.util.List;
import java.util.Optional;


import com.example.fisioapp.model.Patient;
import com.example.fisioapp.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return repository.findById(id);
    }

    public Patient save(Patient patient) {
        boolean existsCpf = false;

        Optional<Patient> optPatient = repository.findByCpf(patient.getCpf());

        if (optPatient.isPresent()) {
            if (!optPatient.get().getId().equals(patient.getId())) {
                existsCpf = true;
            }
        }

        if (existsCpf) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        return repository.save(patient);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Patient createPatient(Patient patient) {
        if (!validaCep(patient.getCep())) {
            throw new IllegalArgumentException("CEP inválido.");
        }

        return patientRepository.save(patient);
    }

    private boolean validaCep(String cep) {
        ViaCepResponse viaCep = cepService.buscarCep(cep);
        return viaCep.getCep() != null;
    }

}