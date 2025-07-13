package com.example.fisioapp.model.dto;

import com.example.fisioapp.model.enm.AppointmentStattus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    @NotNull(message = "O ID do paciente é obrigatório.")
    private Long patientId;

    @NotNull(message = "A data e hora da consulta são obrigatórias.")
    @Future(message = "A data da consulta deve estar no futuro.")
    private LocalDateTime appointmentDayHour;

    @NotNull(message = "O status da consulta é obrigatório.")
    private AppointmentStattus status;

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;


    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getAppointmentDayHour() {
        return appointmentDayHour;
    }

    public void setAppointmentDayHour(LocalDateTime appointmentDayHour) {
        this.appointmentDayHour = appointmentDayHour;
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
