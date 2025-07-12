package com.example.fisioapp.controller;

import com.example.fisioapp.Service.CepService;
import com.example.fisioapp.model.dto.ViaCepResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping(value = "/{cep}", produces = "application/json")
    public ViaCepResponse buscarCep(@PathVariable String cep) {
        return cepService.buscarCep(cep);
    }
}
