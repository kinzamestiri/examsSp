package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Contrat;
import com.example.assuranceexamen.services.IContratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("contrat")
public class ContratRestController {
    IContratService iContratService;

    @PostMapping("/ajoutercontrat")
    public Contrat ajouterContrat (Contrat c){
        return iContratService.ajouterContrat(c);
    }

    @GetMapping("/affichercontrat/{idBf}")
    public Contrat getContratBf(@PathVariable("idBf") int idBf) {
        return iContratService.getContratBf(idBf);
    }

}
