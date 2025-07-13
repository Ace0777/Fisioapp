package com.example.fisioapp.controller;

import com.example.fisioapp.Service.AppointmentService;
import com.example.fisioapp.mapper.AppointmentMapper;
import com.example.fisioapp.model.Appointment;
import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;


    public List<Appointment> findAllAppointment(){
        return appointmentService.findAll();
    }

    public Optional<Appointment> findAppointmentById(Long id){
        return appointmentService.findById(id);
    }

    public Optional<Appointment> findAppointmentByIdPatient(Long id){
        return appointmentService.findAppointmentByIdPatient(id);
    }

    public List<Appointment> findAllAppointmentsByPatientId(Long id) {
        return appointmentService.findAllByPatientId(id);
    }

    public void saveAppointment(AppointmentDTO dto) {
        Appointment appointment = AppointmentMapper.INSTANCE.toEntity(dto);
        appointmentService.saveAppointment(appointment);
    }

    public Appointment updateAppointment(Long id, AppointmentDTO dto) {
        return appointmentService.updateAppointment(id, dto);
    }

    public void deleteAppointment(Long id){
        appointmentService.deleteAppointment(id);
    }
}
