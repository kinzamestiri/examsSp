package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Assurance;
import org.springframework.scheduling.annotation.Scheduled;

public interface IAssuranceService {
    Assurance ajouterAssurance(Assurance a, int cinBf, String matricule);

    @Scheduled(fixedDelay = 6000) // Exécution toutes les 60 secondes
    void statistiques();
}
