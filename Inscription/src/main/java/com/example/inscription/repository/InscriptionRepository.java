package com.example.inscription.repository;

import com.example.inscription.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    List<Inscription> findInscriptionsByIdCours(Long idCours);
}
