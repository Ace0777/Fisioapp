package com.example.fisioapp.Service;

import com.example.fisioapp.model.dto.BrasilApiCepResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public BrasilApiCepResponse buscarCep(String cep) {
        String url = "https://brasilapi.com.br/api/cep/v1/" + cep;
        System.out.println("Consultando BrasilAPI: " + url);

        try {
            ResponseEntity<BrasilApiCepResponse> response =
                    restTemplate.getForEntity(url, BrasilApiCepResponse.class);
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
        BrasilApiCepResponse resp = buscarCep(cep);
        return resp.getCep() != null;
    }
}
