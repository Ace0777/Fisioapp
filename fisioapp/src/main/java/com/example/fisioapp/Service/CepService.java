package com.example.fisioapp.Service;

import com.example.fisioapp.model.dto.ViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ViaCepResponse buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        System.out.println("Buscando CEP em: " + url);

        try {
            ViaCepResponse response = restTemplate.getForObject(url, ViaCepResponse.class);
            System.out.println("Resposta recebida: " + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace(); // imprime o erro no console
            throw e;
        }
    }
}
