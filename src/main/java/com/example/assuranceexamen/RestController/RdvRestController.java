package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Rdv;
import com.example.assuranceexamen.entities.Specialite;
import com.example.assuranceexamen.services.IRDVService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("rdv")
public class RdvRestController {
    IRDVService irdvService;

    @PostMapping("ajouterRDV/{idmedcin}/{idpatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody Rdv rdv, @PathVariable("idmedcin") Long idMedcin,@PathVariable("idpatient") Long idPatient){
        irdvService.addRDVAndAssignMedAndPatient(rdv, idMedcin, idPatient);
    }

    @GetMapping("afficherrdv/{idclinique}/{specialite}")
    public List<Rdv> getRendezVousByCliniqueAndSpecialite(@PathVariable("idclinique") Long idClinique,@PathVariable("specialite") Specialite specialite){
        return irdvService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
}
