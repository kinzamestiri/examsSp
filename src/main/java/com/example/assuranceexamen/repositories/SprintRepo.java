package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepo extends JpaRepository<Sprint,Integer> {
}
