package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Bank;
import com.example.assuranceexamen.entities.Compte;
import com.example.assuranceexamen.repositories.BankRepo;
import com.example.assuranceexamen.repositories.CompteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompteService implements ICompteService{
    CompteRepo compteRepo;
    BankRepo bankRepo;
    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank){
        Bank bank=bankRepo.findByAgence(agenceBank);
        bank.getComptes().add(compte);
        compteRepo.save(compte);
        return compte;
    }



}
