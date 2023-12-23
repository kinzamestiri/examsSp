package com.example.assuranceexamen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAssurance;
    private String designation;
    private Float montant;

    @ManyToOne(cascade = CascadeType.ALL)
    Beneficiaire beneficiaire;

    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat;


}
