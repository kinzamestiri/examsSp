package com.example.assuranceexamen.RestController;

import com.example.assuranceexamen.entities.Transaction;
import com.example.assuranceexamen.entities.TypeTransaction;
import com.example.assuranceexamen.services.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("transaction")
public class TransactionRestController {

    ITransactionService iTransactionService;

    @PostMapping("ajoutvirement")
    public String ajouterVirement(@RequestBody  Transaction transaction){
        return iTransactionService.ajouterVirement(transaction);
    }

    @PostMapping("ajoutretrait")
    public String ajouterRetrait(@RequestBody  Transaction transaction){
        return iTransactionService.ajouterRetrait(transaction);
    }

    @PostMapping("ajoutversement")
    public String ajouterVersement(@RequestBody  Transaction transaction) {
        return iTransactionService.ajouterVersement(transaction);
    }

    @GetMapping("transactionsbyidBank/{idBank}")
    public List<Transaction> getAllTransactionByBankId(@PathVariable("idBank") Long idBank){
        return iTransactionService.getAllTransactionByBankId(idBank);
    }
    @GetMapping("transactionsbyType&idCompte/{type}/{idCompte}")
    public List<Transaction> getAllTransactionByTypeAndCompte(@PathVariable("type") TypeTransaction type,@PathVariable("idCompte") Long idCompte){
        return iTransactionService.getAllTransactionByTypeAndCompte(type,idCompte);
    }

}
