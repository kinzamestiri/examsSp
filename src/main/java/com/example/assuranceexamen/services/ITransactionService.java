package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Transaction;
import com.example.assuranceexamen.entities.TypeTransaction;

import java.util.List;

public interface ITransactionService {
    String ajouterVirement(Transaction transaction);

    String ajouterRetrait(Transaction transaction);

    String ajouterVersement(Transaction transaction);


    List<Transaction> getAllTransactionByBankId(Long idBank);

    List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, Long idCompte);
}
