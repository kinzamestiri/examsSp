package com.example.assuranceexamen.services;


import com.example.assuranceexamen.entities.Bank;
import com.example.assuranceexamen.repositories.BankRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankService implements IBankService{
    BankRepo bankRepo;

    @Override
    public Bank ajouterBank(Bank bank){
        return bankRepo.save(bank);
    }
}
