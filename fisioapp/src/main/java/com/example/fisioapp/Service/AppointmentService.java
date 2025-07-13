package com.example.fisioapp.Service;

import com.example.fisioapp.mapper.AppointmentMapper;
import com.example.fisioapp.mapper.PatientMapper;
import com.example.fisioapp.model.Appointment;
import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.AppointmentDTO;
import com.example.fisioapp.repositories.AppointmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

     public Optional<Appointment> findAppointmentByIdPatient(Long id) {
        return appointmentRepository.findByPatientId(id);
    }

    public List<Appointment> findAllByPatientId(Long id) {
        return appointmentRepository.findAllByPatientId(id);
    }


    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }


    public Appointment updateAppointment(Long id, AppointmentDTO dto) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        AppointmentMapper.INSTANCE.updateAppointmentFromDto(dto, existingAppointment);

        return appointmentRepository.save(existingAppointment);
    }


    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }


}
