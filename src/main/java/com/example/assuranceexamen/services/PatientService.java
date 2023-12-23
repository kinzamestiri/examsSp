package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Patient;
import com.example.assuranceexamen.repositories.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService implements IPatientService{
    PatientRepo patientRepo;

    @Override
    public Patient addPatient(Patient patient){
        return patientRepo.save(patient);

    }

}
