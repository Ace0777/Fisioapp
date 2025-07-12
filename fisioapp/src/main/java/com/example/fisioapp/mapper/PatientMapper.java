package com.example.fisioapp.mapper;

import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.PatientDTO;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity(PatientDTO dto);

    PatientDTO toDTO(Patient entity);

     void updatePatientFromDto(PatientDTO dto, @MappingTarget Patient entity);

}
