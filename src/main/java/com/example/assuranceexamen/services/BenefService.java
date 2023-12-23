package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Assurance;
import com.example.assuranceexamen.entities.Beneficiaire;
import com.example.assuranceexamen.entities.TypeContrat;
import com.example.assuranceexamen.repositories.AssuranceRepo;
import com.example.assuranceexamen.repositories.BenefRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BenefService implements IBenefImpl{
    BenefRepo benefRepo;
    AssuranceRepo assuranceRepo;
    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf){
        return benefRepo.save(bf);
    }

    @Override
    public Set<Beneficiaire> getBeneficiairesByType(TypeContrat typeContrat) {
        Set<Beneficiaire> beneficiaires = new HashSet<>();
        List<Assurance> assurances = assuranceRepo.findByContratType(typeContrat);
        for (Assurance assurance : assurances) {
            beneficiaires.add(assurance.getBeneficiaire());
        }
        return beneficiaires;
    }
}
