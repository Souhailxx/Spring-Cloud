package com.example.inscription.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoursDTO {

    private Long idCours;
    private String nomCours;
    private int nbr_heures;
    private String module;
    private String filliere;
    private boolean specialite;


    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    @JsonProperty("nomCours")
    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    @JsonProperty("nbr_heures")
    public int getNbr_heures() {
        return nbr_heures;
    }

    public void setNbr_heures(int nbr_heures) {
        this.nbr_heures = nbr_heures;
    }

    @JsonProperty("module")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @JsonProperty("filliere")
    public String getFilliere() {
        return filliere;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    @JsonProperty("specialite")
    public boolean isSpecialite() {
        return specialite;
    }

    public void setSpecialite(boolean specialite) {
        this.specialite = specialite;
    }

    public CoursDTO(Long idCours, String nomCours, int nbr_heures, String module, String filliere, boolean specialite) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.nbr_heures = nbr_heures;
        this.module = module;
        this.filliere = filliere;
        this.specialite = specialite;
    }

    public CoursDTO(){}
}