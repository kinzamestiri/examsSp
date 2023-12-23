package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Rdv;
import com.example.assuranceexamen.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RDVRepo extends JpaRepository<Rdv,Long> {
    @Query("SELECT r FROM Rdv r " +
            "JOIN r.medcin m " +
            "JOIN m.cliniques c " +
            "WHERE c.idClinique = :idClinique AND m.specialite = :specialite")
    List<Rdv>  findRdvByCliniqueAndSpecialite(@Param("idClinique") Long idClinique, @Param("specialite") Specialite specialite);

    List<Rdv> findByMedcinIdMedecinAndDateRDVBetween(Long idMedecin, LocalDate startDate, LocalDate endDate);
}
