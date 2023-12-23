package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Medcin;
import com.example.assuranceexamen.entities.Patient;
import com.example.assuranceexamen.entities.Rdv;
import com.example.assuranceexamen.entities.Specialite;
import com.example.assuranceexamen.repositories.MedcinRepo;
import com.example.assuranceexamen.repositories.PatientRepo;
import com.example.assuranceexamen.repositories.RDVRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RDVService implements IRDVService{
    RDVRepo rdvRepo;
    MedcinRepo medcinRepo;
    PatientRepo patientRepo;
    @Override
    public void addRDVAndAssignMedAndPatient(Rdv rdv, Long idMedcin, Long idPatient){
        Medcin m=medcinRepo.findById(idMedcin).orElse(null);
        Patient p=patientRepo.findById(idPatient).orElse(null);
        rdv.setMedcin(m);
        rdv.setPatient(p);
        rdvRepo.save(rdv);
    }

    @Override
    public List<Rdv> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite){
        return rdvRepo.findRdvByCliniqueAndSpecialite(idClinique,specialite);
    }

    @Scheduled(fixedRate = 300000) // Exécuter toutes les 30 secondes
    public void retrieveRendezVous() {
        List<Rdv> rendezVousList = rdvRepo.findAll();
        LocalDate dateSysteme = LocalDate.now();
        for (Rdv rendezVous : rendezVousList) {
            if (rendezVous.getDateRDV().isAfter(dateSysteme)) {
                log.info("dateRDV: " + rendezVous.getDateRDV() +
                        " Medecin: " + rendezVous.getMedcin().getNomMedecin() +
                        " Patient: " + rendezVous.getPatient().getNomPatient());
            }
        }
    }

}
