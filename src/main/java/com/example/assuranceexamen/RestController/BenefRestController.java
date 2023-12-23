package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Beneficiaire;
import com.example.assuranceexamen.entities.TypeContrat;
import com.example.assuranceexamen.services.IBenefImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("benef")
public class BenefRestController {
    IBenefImpl iBenef;
    @PostMapping("/ajouterbenef")
    public Beneficiaire ajouterBeneficiaire (Beneficiaire bf){
        return iBenef.ajouterBeneficiaire(bf);
    }

    @GetMapping("/afficherbenef/{type}")
    public Set<Beneficiaire> getBeneficairesByType (@PathVariable("type") TypeContrat typeContrat){
        return iBenef.getBeneficiairesByType(typeContrat);
    }
}
