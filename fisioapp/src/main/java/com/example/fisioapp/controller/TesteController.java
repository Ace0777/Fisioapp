package com.example.fisioapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TesteController {

    @GetMapping("/status")
    public String status() {
        return "Aplicação ativa!";
    }
}

