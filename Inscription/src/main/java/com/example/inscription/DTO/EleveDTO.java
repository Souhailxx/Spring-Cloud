package com.example.inscription.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EleveDTO {

    private Long idEleve;
    private String firstName;
    private String lastName;
    private String filliere;

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("filliere")
    public String getFilliere() {
        return filliere;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    public EleveDTO(Long idEleve, String firstName, String lastName, String filliere) {
        this.idEleve = idEleve;
        this.firstName = firstName;
        this.lastName = lastName;
        this.filliere = filliere;
    }

    public EleveDTO(){}
}
