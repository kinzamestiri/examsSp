package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Clinique;
import com.example.assuranceexamen.repositories.CliniqueRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CliniqueService implements ICliniqueService{
    CliniqueRepo cliniqueRepo;

    @Override
    public Clinique addClinique (Clinique clinique){
        return cliniqueRepo.save(clinique);
    }

}
