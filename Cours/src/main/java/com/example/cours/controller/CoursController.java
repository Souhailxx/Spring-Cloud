package com.example.cours.controller;

import com.example.cours.entity.Cours;
import com.example.cours.repository.CoursRepository;
import io.micrometer.tracing.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class CoursController {

    private final CoursRepository coursRepository;

    public CoursController(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/all")
    public ResponseEntity<List<Cours>> getAll(){
        log.info("Listing All cours");
        List<Cours> cours = coursRepository.findAll();
        return ResponseEntity.ok(cours);
    }
}
