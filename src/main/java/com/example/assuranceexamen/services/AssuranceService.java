package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Assurance;
import com.example.assuranceexamen.entities.Beneficiaire;
import com.example.assuranceexamen.entities.Contrat;
import com.example.assuranceexamen.repositories.AssuranceRepo;
import com.example.assuranceexamen.repositories.BenefRepo;
import com.example.assuranceexamen.repositories.ContratRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class AssuranceService implements IAssuranceService{
    AssuranceRepo assuranceRepo;
    BenefRepo benefRepo;
    ContratRepo contratRepo;

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, String matricule){
        Beneficiaire b  = benefRepo.findByCin(cinBf);
        Contrat c = contratRepo.findByMatricule(matricule);
        a.setBeneficiaire(b);
        a.setContrat(c);
        return  assuranceRepo.save(a);
    }


    @Override
    @Transactional
    @Scheduled(cron = "*/6000 * * * * *")
    public void statistiques() {

        TreeMap<Integer, Integer> myStat = new TreeMap<>(Collections.reverseOrder());

        for (Beneficiaire b : benefRepo.findAll()) {
            myStat.put(b.getAssurances().size(), b.getCin());
        }
        for (Map.Entry<Integer, Integer> va : myStat.entrySet()) {
            log.info(va.getKey() + "|" + va.getValue());
        }
    }
}
