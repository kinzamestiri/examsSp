package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Bank,Long> {

    Bank findByAgence(String agence);
}
