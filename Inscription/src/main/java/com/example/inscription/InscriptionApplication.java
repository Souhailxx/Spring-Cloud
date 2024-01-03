package com.example.inscription;

import com.example.inscription.service.InscriptionService2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class InscriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscriptionApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    CommandLineRunner commandLineRunner(InscriptionService2 inscriptionService2) {

        return (args) -> {


        };
    }

}
