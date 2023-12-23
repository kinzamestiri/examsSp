package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Clinique;
import com.example.assuranceexamen.entities.Medcin;
import com.example.assuranceexamen.entities.Rdv;
import com.example.assuranceexamen.repositories.CliniqueRepo;
import com.example.assuranceexamen.repositories.MedcinRepo;
import com.example.assuranceexamen.repositories.RDVRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MedcinService implements IMedcinService{
    MedcinRepo medcinRepo;
    CliniqueRepo cliniqueRepo;
    RDVRepo rdvRepo;

    @Override
    public Medcin addMedecinAndAssignToClinique(Medcin medecin, Long cliniqueId){
        Clinique c= cliniqueRepo.findById(cliniqueId).orElse(null);
        if (c != null) {
            medecin.getCliniques().add(c);
            c.getMedcins().add(medecin);

            medecin = medcinRepo.save(medecin);
            c = cliniqueRepo.save(c);
        }

        return medecin;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin){
        return medcinRepo.getNombreRdv(idMedecin);
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, LocalDate startDate, LocalDate endDate) {
        // Logique pour récupérer les rendez-vous du médecin entre les deux dates
        List<Rdv> rendezVousList = rdvRepo.findByMedcinIdMedecinAndDateRDVBetween(idMedecin, startDate, endDate);

        // Calcul du revenu en fonction du nombre de rendez-vous
        int prixConsultation = medcinRepo.getPrixConsultation(idMedecin);
        int revenu = rendezVousList.size() * prixConsultation;

        return revenu;
    }

}

