package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Assurance;
import com.example.assuranceexamen.services.IAssuranceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("assurance")
public class AssuranceRestController {
    IAssuranceService iAssuranceService;

    @PostMapping("/ajouterassurance/{cin}/{matricule}")
    public Assurance ajouterAssurance (@RequestBody Assurance a, @PathVariable("cin") int cinBf,@PathVariable("matricule") String matricule){
        return iAssuranceService.ajouterAssurance(a,cinBf,matricule);
    }
}
