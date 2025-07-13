package com.example.fisioapp.mapper;

import com.example.fisioapp.model.Appointment;
import com.example.fisioapp.model.dto.AppointmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    Appointment toEntity(AppointmentDTO dto);

    AppointmentDTO toDTO(Appointment entity);

     void updateAppointmentFromDto(AppointmentDTO dto, @MappingTarget Appointment entity);

}
