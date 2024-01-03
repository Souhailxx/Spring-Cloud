package com.example.inscription.service;

import com.example.inscription.DTO.CoursDTO;
import com.example.inscription.DTO.EleveDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EleveClient", url = "http://localhost:8081")
public interface EleveClient {

    @GetMapping("/etudiants/{idEleve}")
    EleveDTO getElevebyID(@PathVariable("idEleve")Long id);
}
