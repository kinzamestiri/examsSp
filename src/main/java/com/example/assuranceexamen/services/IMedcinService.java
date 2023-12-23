package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Medcin;

import java.time.LocalDate;

public interface IMedcinService {
    Medcin addMedecinAndAssignToClinique(Medcin medecin, Long cliniqueId);

    int getNbrRendezVousMedecin(Long idMedecin);

    int getRevenuMedecin(Long idMedecin, LocalDate startDate, LocalDate endDate);
}
