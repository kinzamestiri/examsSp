package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Beneficiaire;
import com.example.assuranceexamen.entities.TypeContrat;

import java.util.Set;

public interface IBenefImpl {
    Beneficiaire ajouterBeneficiaire(Beneficiaire bf);



    Set<Beneficiaire> getBeneficiairesByType(TypeContrat typeContrat);
}
