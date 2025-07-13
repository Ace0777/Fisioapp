package com.example.fisioapp;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FisioappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FisioappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App rodando. Pressione Ctrl+C para sair.");
	}



}
