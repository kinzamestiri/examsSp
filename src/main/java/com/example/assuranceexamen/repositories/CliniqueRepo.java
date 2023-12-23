package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueRepo extends JpaRepository<Clinique,Long> {


}
