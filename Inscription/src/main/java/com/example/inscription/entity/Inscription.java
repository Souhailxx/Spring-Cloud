package com.example.inscription.entity;

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
public class Inscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idEleve;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Long idCours;

    @Column(name = "cours_name")
    private String coursName;

    @Column(name = "module_cours")
    private String module;

    @Column(name = "filliere")
    private String filliere;

    @Column(name = "specialite")
    private boolean specialite;
}
