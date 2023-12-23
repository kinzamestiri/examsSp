package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Assurance;
import com.example.assuranceexamen.entities.Beneficiaire;
import com.example.assuranceexamen.entities.Contrat;
import com.example.assuranceexamen.entities.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AssuranceRepo extends JpaRepository<Assurance,Integer> {
    Set<Assurance> findAssurancesByContratType(TypeContrat typeContrat);

    List<Assurance> findByContratType(TypeContrat typeContrat);
}
