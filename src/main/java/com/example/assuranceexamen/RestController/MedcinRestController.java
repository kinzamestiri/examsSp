package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Medcin;
import com.example.assuranceexamen.services.IMedcinService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping("medcin")
public class MedcinRestController {
    IMedcinService iMedcinService;
    @PostMapping("ajoutermedecinetclinique/{cliniqueId}")
    public Medcin addMedecinAndAssignToClinique (@RequestBody  Medcin medecin,@PathVariable("cliniqueId") Long cliniqueId){
        return iMedcinService.addMedecinAndAssignToClinique(medecin,cliniqueId);
    }

    @GetMapping("nbrrdv/{idmedecin}")
    public int getNbrRendezVousMedecin(@PathVariable("idmedecin") Long idMedecin){
        return iMedcinService.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("/revenu/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(@PathVariable("idMedecin") Long idMedecin,
             @PathVariable("startDate") LocalDate startDate,
            @PathVariable("endDate") LocalDate endDate
    ) {
        return iMedcinService.getRevenuMedecin(idMedecin,startDate,endDate);
    }
}
