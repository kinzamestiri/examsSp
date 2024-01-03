package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepo extends JpaRepository<Compte,Long> {
}
