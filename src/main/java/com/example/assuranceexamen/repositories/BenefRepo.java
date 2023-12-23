package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Assurance;
import com.example.assuranceexamen.entities.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface BenefRepo extends JpaRepository<Beneficiaire,Integer> {

    Beneficiaire findByCin(int cinBf);
    Set<Beneficiaire> findByAssurancesIn(Set<Assurance> assurances);


}
