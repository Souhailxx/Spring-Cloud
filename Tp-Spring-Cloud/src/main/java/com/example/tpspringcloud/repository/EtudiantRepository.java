package com.example.tpspringcloud.repository;

import com.example.tpspringcloud.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}