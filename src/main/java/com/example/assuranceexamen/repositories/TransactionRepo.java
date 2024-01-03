package com.example.assuranceexamen.repositories;

import com.example.assuranceexamen.entities.Transaction;
import com.example.assuranceexamen.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    List<Transaction> findByDateTransaction(LocalDate today);
    @Query("SELECT DISTINCT t FROM Transaction t " +
            "JOIN t.expediteur e " +
            "JOIN t.destinataire d " +
            "WHERE e IN (SELECT c FROM Bank b " +
            "JOIN b.comptes c WHERE b.idBank = :idBank) OR " +
            "d IN (SELECT c FROM Bank b " +
            "JOIN b.comptes c WHERE b.idBank = :idBank)")
    List<Transaction> getTransactionsByBankId(@Param("idBank") Long idBank);

    List<Transaction> findByTypeAndExpediteur_IdCompte(TypeTransaction type, Long idCompte);

    List<Transaction> findByTypeAndDestinataire_IdCompte(TypeTransaction type, Long idCompte);
}
