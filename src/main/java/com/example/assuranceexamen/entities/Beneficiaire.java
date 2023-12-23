package com.example.assuranceexamen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beneficiaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBenef;
    private Integer cin;
    private String nom;
    private String prenom;
    private String profession;
    private Float salaire;

    @OneToMany(mappedBy = "beneficiaire" )
    Set<Assurance>assurances;

}
