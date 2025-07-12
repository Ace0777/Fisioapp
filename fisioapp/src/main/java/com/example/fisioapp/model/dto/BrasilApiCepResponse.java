package com.example.fisioapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrasilApiCepResponse {

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("street")
    private String street;

    @JsonProperty("service")
    private String service;

    @Override
    public String toString() {
        return "BrasilApiCepResponse{" +
                "cep='" + cep + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", street='" + street + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
