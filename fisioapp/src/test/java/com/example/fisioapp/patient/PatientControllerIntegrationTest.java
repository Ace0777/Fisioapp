package com.example.fisioapp.patient;

import com.example.fisioapp.model.Patient;
import com.example.fisioapp.model.dto.PatientDTO;
import com.example.fisioapp.repositories.PatientRepository;
import com.example.fisioapp.service.CepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerIntegrationTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        public CepService cepService() {
            return new CepService() {
                @Override
                public boolean validaCep(String cep) {
                    return true;
                }
            };
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        patientRepository.deleteAll(); // Limpa banco antes de cada teste
    }

    private PatientDTO createPatientDto() {
        PatientDTO dto = new PatientDTO();
        dto.setName("João Silva");
        dto.setCpf("12345678901");
        dto.setAge(30);
        dto.setPhone("11999999999");
        dto.setObservations("Nenhuma");
        dto.setCep("01001000");  // CEP válido de exemplo
        return dto;
    }

    @Test
    public void testCreateAndFindPatient() throws Exception {
        PatientDTO dto = createPatientDto();

        mockMvc.perform(post("/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/patient"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].cpf", is(dto.getCpf())));

        System.out.println("testCreateAndFindPatient passou com sucesso!");
    }

    @Test
    public void testFindPatientById() throws Exception {
        Patient patient = new Patient();
        patient.setName("Maria");
        patient.setCpf("09876543210");
        patient.setAge(25);
        patient.setPhone("11988888888");
        patient.setObservations("Teste");
        patient.setCep("01001000");
        patient = patientRepository.save(patient);

        mockMvc.perform(get("/patient/" + patient.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Maria")))
                .andExpect(jsonPath("$.cpf", is("09876543210")));

        System.out.println("testFindPatientById passou com sucesso!");
    }

    @Test
    public void testUpdatePatient() throws Exception {
        Patient patient = new Patient();
        patient.setName("Carlos");
        patient.setCpf("11122233344");
        patient.setAge(40);
        patient.setPhone("11977777777");
        patient.setObservations("");
        patient.setCep("01001000");
        patient = patientRepository.save(patient);

        PatientDTO updatedDto = new PatientDTO();
        updatedDto.setName("Carlos Atualizado");
        updatedDto.setCpf("11122233344");
        updatedDto.setAge(41);
        updatedDto.setPhone("11977777777");
        updatedDto.setObservations("Atualizado");
        updatedDto.setCep("01001000");

        mockMvc.perform(put("/patient/" + patient.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Carlos Atualizado")))
                .andExpect(jsonPath("$.age", is(41)));

        System.out.println("testUpdatePatient passou com sucesso!");
    }

    @Test
    public void testDeletePatient() throws Exception {
        Patient patient = new Patient();
        patient.setName("Delete Test");
        patient.setCpf("99988877766");
        patient.setAge(50);
        patient.setPhone("11966666666");
        patient.setObservations("");
        patient.setCep("01001000");
        patient = patientRepository.save(patient);

        mockMvc.perform(delete("/patient/" + patient.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/patient/" + patient.getId()))
                .andExpect(status().isNotFound());

        System.out.println("testDeletePatient passou com sucesso!");
    }
}