package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Clinique;
import com.example.assuranceexamen.services.ICliniqueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("clinique")
public class CliniqueRestController {
    ICliniqueService iCliniqueService;
    @PostMapping("/ajouterclinique")
    public Clinique addClinique (@RequestBody  Clinique clinique){
        return iCliniqueService.addClinique(clinique);
    }
}
