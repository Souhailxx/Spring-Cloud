package com.example.cours.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cours")
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_cours")
    private String nomCours;

    @Column(name = "nombre_heure_totales")
    private int nbr_heures;

    @Column(name = "nom_module")
    private String module;

    @Column(name = "fillière")
    private String filliere;

    @Column(name = "specialite")
    private boolean specialite;
}
