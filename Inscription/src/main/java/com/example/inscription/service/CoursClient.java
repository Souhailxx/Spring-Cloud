package com.example.inscription.service;

import com.example.inscription.DTO.CoursDTO;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CoursClient", url = "http://localhost:8082")
public interface CoursClient {

    @GetMapping("/cours/{idCours}")
    CoursDTO getCoursbyID(@PathVariable("idCours")Long id);
}
