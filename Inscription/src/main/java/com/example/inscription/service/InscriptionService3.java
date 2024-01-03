package com.example.inscription.service;

import com.example.inscription.DTO.CoursDTO;
import com.example.inscription.DTO.EleveDTO;
import com.example.inscription.entity.Inscription;
import com.example.inscription.repository.InscriptionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService3 {

    @Autowired
    private CoursClient coursClient;

    @Autowired
    private EleveClient eleveClient;

    private final InscriptionRepository inscriptionRepository;

    public InscriptionService3(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    public Inscription assignElevetoCours3(Long idEleve, Long idCours) throws JsonProcessingException {

        EleveDTO newEleveDTO = eleveClient.getElevebyID(idEleve);

        CoursDTO newCoursDTO = coursClient.getCoursbyID(idCours);



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

    public List<Inscription> viewEleveinCours(Long idCours){

        return inscriptionRepository.findInscriptionsByIdCours(idCours);
    }

    public List<Inscription> viewAll(){
        return inscriptionRepository.findAll();
    }
}
