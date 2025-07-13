package com.example.fisioapp.controller.exceptions;


import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandlerController {

    public static ResponseEntity<?> handleException(Exception ex) {
        if (ex instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"erro\": \"Registro não encontrado: " + ex.getMessage() + "\"}");
        } else if (ex instanceof ValidationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"erro\": \"Erro de validação: " + ex.getMessage() + "\"}");
        } else if (ex instanceof DataIntegrityViolationException) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("{\"erro\": \"Violação de integridade: " + ex.getMessage() + "\"}");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"erro\": \"Erro inesperado: " + ex.getMessage() + "\"}");
        }
    }
}

