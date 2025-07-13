package com.example.fisioapp.Service;

import com.example.fisioapp.model.dto.BrasilApiCepResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public BrasilApiCepResponseDTO buscarCep(String cep) {
        String url = "https://brasilapi.com.br/api/cep/v1/" + cep;
        System.out.println("Consultando BrasilAPI: " + url);

        try {
            ResponseEntity<BrasilApiCepResponseDTO> response =
                    restTemplate.getForEntity(url, BrasilApiCepResponseDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            System.err.println("CEP não encontrado: " + cep);
            throw new IllegalArgumentException("CEP não encontrado.");
        } catch (Exception e) {
            System.err.println("Erro ao consultar BrasilAPI: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar CEP", e);
        }
    }

    public boolean validaCep(String cep) {
        BrasilApiCepResponseDTO resp = buscarCep(cep);
        return resp.getCep() != null;
    }
}
