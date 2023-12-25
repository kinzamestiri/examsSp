package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.User;
import com.example.assuranceexamen.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    UserRepo userRepo;
    @Override
    public User addUser (User user){
        return userRepo.save(user);
    }
}
