package com.example.inscription.service;

import com.example.inscription.DTO.CoursDTO;
import com.example.inscription.DTO.EleveDTO;
import com.example.inscription.entity.Inscription;
import com.example.inscription.repository.InscriptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class InscriptionService2 {

    private final WebClient webClient1;
    private final WebClient webClient2;

    private final InscriptionRepository inscriptionRepository;


    public InscriptionService2(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.webClient1 = WebClient.create("http://localhost:8081");
        this.webClient2 = WebClient.create("http://localhost:8082");
    }

    public Inscription assignElevetoCours2(Long idEleve, Long idCours) throws JsonProcessingException {

        String responseEleve = webClient1.get()
                .uri("/etudiants/" + idEleve.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String responseCours = webClient2.get()
                .uri("/cours/" + idCours.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return stringToInscription(responseEleve, responseCours, inscriptionRepository, idEleve, idCours);
    }

    static Inscription stringToInscription(String responseEleve, String responseCours, InscriptionRepository inscriptionRepository, Long idEleve, Long idCours) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        EleveDTO newEleveDTO = objectMapper.readValue(responseEleve, EleveDTO.class);
        newEleveDTO.setIdEleve(idEleve);
        CoursDTO newCoursDTO = objectMapper.readValue(responseCours, CoursDTO.class);
        newCoursDTO.setIdCours(idCours);



        Inscription newInscription = Inscription.builder()
                .idCours(idCours)
                .idEleve(idEleve)
                .firstName(newEleveDTO.getFirstName())
                .lastName(newEleveDTO.getLastName())
                .filliere(newCoursDTO.getFilliere())
                .coursName(newCoursDTO.getNomCours())
                .module(newCoursDTO.getModule())
                .specialite(newCoursDTO.isSpecialite())
                .build();

        return inscriptionRepository.save(newInscription);
    }

    public CoursDTO viewCoursInfo(Long idCours){
        Inscription inscription = (Inscription) inscriptionRepository.findInscriptionsByIdCours(idCours);
        CoursDTO coursDTO = CoursDTO.builder()
                .nomCours(inscription.getCoursName())
                .build();
        return coursDTO;
    }


    public List<Inscription> viewEleveinCours(Long idCours){

        return inscriptionRepository.findInscriptionsByIdCours(idCours);
    }
}
