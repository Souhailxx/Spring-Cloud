package com.example.inscription.controller;

import com.example.inscription.entity.Inscription;
import com.example.inscription.service.InscriptionService;
import com.example.inscription.service.InscriptionService2;
import com.example.inscription.service.InscriptionService3;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class InscriptionController {

    private final InscriptionService inscriptionService;

    private final InscriptionService2 inscriptionService2;

    private final InscriptionService3 inscriptionService3;

    @Value("${somekey}")
    private String myKey;
    /*@Value("${some.key2}")
    private String myKey2;
    @Value("${some.key3}")
    private String myKey3;*/


    public InscriptionController(InscriptionService inscriptionService, InscriptionService2 inscriptionService2, InscriptionService3 inscriptionService3) {
        this.inscriptionService = inscriptionService;
        this.inscriptionService2 = inscriptionService2;
        this.inscriptionService3 = inscriptionService3;
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/message")
    public String prop() {
        log.info("Microservice = {}", this.myKey);
        return "Microservice = " + this.myKey;
    }

    @GetMapping("/inscriptions/all")
    public ResponseEntity<List<Inscription>> getAllInscriptions(){
        log.info("Listing All Users");
        List<Inscription> inscrptions = inscriptionService3.viewAll();
        return ResponseEntity.ok(inscrptions);
    }
    @GetMapping("/inscriptions/{idCours}")
    public List<Inscription> viewEleveinCours(@PathVariable("idCours") Long idCours) {
        return inscriptionService3.viewEleveinCours(idCours);
    }

    @PostMapping("/inscriptions/{idEleve}/{idCours}")
    public Inscription addElevetoCours(@PathVariable("idEleve") Long idELeve,
                                       @PathVariable("idCours") Long idCours) throws JsonProcessingException {

        return inscriptionService3.assignElevetoCours3(idELeve, idCours);
    }


}
