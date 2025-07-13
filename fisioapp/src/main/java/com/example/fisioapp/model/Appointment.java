package com.example.fisioapp.model;

import com.example.fisioapp.model.enm.AppointmentStattus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment" )
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDateTime AppointmentDayHour;

    @Enumerated(EnumType.STRING)
    private AppointmentStattus status;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getAppointmentDayHour() {
        return AppointmentDayHour;
    }

    public void setAppointmentDayHour(LocalDateTime appointmentDayHour) {
        AppointmentDayHour = appointmentDayHour;
    }

    public AppointmentStattus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStattus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
