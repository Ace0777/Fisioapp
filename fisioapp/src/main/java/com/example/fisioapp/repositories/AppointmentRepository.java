package com.example.fisioapp.repositories;

import com.example.fisioapp.model.Appointment;
import com.example.fisioapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByPatientId(Long patientId);

    Optional<Appointment> findByPatientId(Long id);

}
