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
@Entity(name = "Appointment")
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
}
