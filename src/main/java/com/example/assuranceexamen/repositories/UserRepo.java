package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.role = 'Developer' AND u.id = :devId")
    User findUserByIdAndRoleDeveloper(@Param("devId") int devId);

    @Query("SELECT u FROM User u WHERE u.role = 'Scrum_master' AND u.fName = :fName and u.lName= :lName")
    User findScrumMaster(@Param("fName")String fName , @Param("lName")String lName);


}
