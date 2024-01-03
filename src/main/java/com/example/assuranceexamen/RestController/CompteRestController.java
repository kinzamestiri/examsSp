package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Compte;
import com.example.assuranceexamen.services.ICompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("compte")
public class CompteRestController {
    ICompteService iCompteService;

    @PostMapping("ajoutercompteetaffecteraagence/{agenceBank}")
    public Compte ajouterCompteEtAffecterAAgence(@RequestBody Compte compte,@PathVariable("agenceBank") String agenceBank){
        return iCompteService.ajouterCompteEtAffecterAAgence(compte,agenceBank);
    }
}
