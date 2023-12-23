package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Beneficiaire;
import com.example.assuranceexamen.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContratRepo extends JpaRepository<Contrat,Integer> {
    Contrat findByMatricule(String matricule);



    @Query("SELECT c FROM Assurance a " +
            "JOIN a.beneficiaire b " +
            "JOIN a.contrat c " +
            "WHERE b.idBenef = :idBf AND c.dateEffet = (SELECT MIN(c2.dateEffet) FROM Assurance a2 JOIN a2.contrat c2 JOIN a2.beneficiaire b2 WHERE b2.idBenef = :idBf)")
    Contrat findContratByBeneficiaireIdWithMinDate(int idBf);


}
