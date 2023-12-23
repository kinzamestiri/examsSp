package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedcinRepo extends JpaRepository<Medcin,Long> {

    @Query("SELECT COUNT(r) FROM Medcin m JOIN m.rdvs r WHERE m.idMedecin = :idMedecin")
    int getNombreRdv(@Param("idMedecin") Long idMedecin);

    @Query("SELECT m.prixConsultation FROM Medcin m WHERE  m.idMedecin = :idMedecin")
    int getPrixConsultation(@Param("idMedecin") Long idMedecin);
}
