package com.example.fisioapp.controller;

import com.example.fisioapp.Service.CepService;
import com.example.fisioapp.controller.exceptions.ExceptionHandlerController;
import com.example.fisioapp.model.dto.BrasilApiCepResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    private String test;

    @GetMapping(value = "/{cep}", produces = "application/json")
    public ResponseEntity<?> buscarCep(@PathVariable String cep) {
        try {
            BrasilApiCepResponseDTO resposta = cepService.buscarCep(cep);
            return ResponseEntity.ok(resposta);
        } catch (Exception e) {
            return ExceptionHandlerController.handleException(e);
        }
    }

    @GetMapping(value = "/valida/{cep}")
    public ResponseEntity<Boolean> validaCep(@PathVariable String cep) {
        try {
            boolean valido = cepService.validaCep(cep);
            return ResponseEntity.ok(valido);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }
}
