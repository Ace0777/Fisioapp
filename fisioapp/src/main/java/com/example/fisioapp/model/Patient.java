package com.example.fisioapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
@Entity(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private String phone;
    private String  observations;
    private String cep;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
