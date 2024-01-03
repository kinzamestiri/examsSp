package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Bank;
import com.example.assuranceexamen.services.IBankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("bank")
public class BankRestController {
    IBankService iBankService;

    @PostMapping("ajouterBank")
    public Bank ajouterBank(@RequestBody Bank bank){
        return iBankService.ajouterBank(bank);
    }
}
