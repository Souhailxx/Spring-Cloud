package com.example.cours.repository;

import com.example.cours.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cours")
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
