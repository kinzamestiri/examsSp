package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Rdv;
import com.example.assuranceexamen.entities.Specialite;

import java.util.List;

public interface IRDVService {
    void addRDVAndAssignMedAndPatient(Rdv rdv, Long idMedcin, Long idPatient);

    List<Rdv> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);
}
