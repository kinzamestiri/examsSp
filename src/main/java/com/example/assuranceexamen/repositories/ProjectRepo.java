package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Project;
import com.example.assuranceexamen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {

    @Query("SELECT p FROM User u " +
            "JOIN u.projectSet p " +
            "WHERE u.role = 'Scrum_master' AND u.fName = :fName and u.lName= :lName")
    List<Project> findRdvByNames(@Param("fName")String fName , @Param("lName")String lName);

    @Query("SELECT p FROM Project p " +
            "JOIN p.sprints s " +
            "WHERE s.startDate < :currentDate")
    List<Project> findBySprint(@Param("currentDate") LocalDate currentDate);

}
