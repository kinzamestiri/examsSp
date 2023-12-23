package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Assurance;
import com.example.assuranceexamen.entities.Contrat;
import com.example.assuranceexamen.repositories.AssuranceRepo;
import com.example.assuranceexamen.repositories.ContratRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContratService implements IContratService{
    ContratRepo contratRepo;
    AssuranceRepo assuranceRepo;
    @Override
    public Contrat ajouterContrat (Contrat c){
        return contratRepo.save(c);
    }
    @Override
    public Contrat getContratBf(int idBf) {
        return contratRepo.findContratByBeneficiaireIdWithMinDate(idBf);
    }

}
