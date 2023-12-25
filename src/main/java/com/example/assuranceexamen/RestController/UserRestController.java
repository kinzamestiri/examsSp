package com.example.assuranceexamen.RestController;


import com.example.assuranceexamen.entities.User;
import com.example.assuranceexamen.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserRestController {
    IUserService iUserService;
    @PostMapping("ajouteruser")
    public User addUser (@RequestBody User user){
        return iUserService.addUser(user);
    }
}
