package com.example.fisioapp.controller;

import com.example.fisioapp.Service.CepService;
import com.example.fisioapp.model.dto.BrasilApiCepResponse;
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
            BrasilApiCepResponse resposta = cepService.buscarCep(cep);
            return ResponseEntity.ok(resposta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("{\"erro\": \"CEP não encontrado\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"erro\": \"Erro interno ao buscar CEP\"}");
        }
    }

    @GetMapping(value = "/valida/{cep}")
    public boolean validaCep(@PathVariable String cep) {
        try {
            return cepService.validaCep(cep);
        } catch (IllegalArgumentException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
