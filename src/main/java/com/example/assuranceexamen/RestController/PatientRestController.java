package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Patient;
import com.example.assuranceexamen.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("patient")
public class PatientRestController {
    IPatientService iPatientService;
    @PostMapping("ajouterpatient")
    public Patient addPatient(@RequestBody  Patient patient){
        return iPatientService.addPatient(patient);
    }

}
