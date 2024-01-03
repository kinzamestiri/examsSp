package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Compte;
import com.example.assuranceexamen.entities.Transaction;
import com.example.assuranceexamen.entities.TypeTransaction;
import com.example.assuranceexamen.repositories.CompteRepo;
import com.example.assuranceexamen.repositories.TransactionRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.assuranceexamen.entities.TypeCompte.COURANT;
import static com.example.assuranceexamen.entities.TypeCompte.EPARGNE;
import static com.example.assuranceexamen.entities.TypeTransaction.*;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionService implements ITransactionService{

    TransactionRepo transactionRepo;
    CompteRepo compteRepo;

    @Override
    public String ajouterVirement(Transaction transaction){
        String msg="";
        if (transaction.getType()==VIREMENT){
            if (transaction.getExpediteur().getType() == EPARGNE){
                msg="On ne peut pas faire un virement à partir d’un compte épargne";
            } else if (transaction.getMontant() > (transaction.getExpediteur().getSolde()+3) && transaction.getExpediteur().getType()== COURANT) {
                msg="On ne peut pas faire un virement : Solde insuffisant";
            }else {
                Compte destinataire = transaction.getDestinataire();
                if (destinataire.getIdCompte() == null) {
                    destinataire = compteRepo.save(destinataire);
                    transaction.setDestinataire(destinataire);
                }
                // Save the transaction
                msg = "VIREMENT de " + transaction.getMontant() + " DT de compte" + transaction.getExpediteur().getCode() + "vers le compte " + transaction.getDestinataire().getCode() + " approuvé avec succès.";
                transactionRepo.save(transaction);
            }
        }
        return msg;
    }
    @Override
    public String ajouterRetrait(Transaction transaction) {
        String msg = "";
        if (transaction.getType() == RETRAIT) {
            if ((transaction.getMontant() + 2) < transaction.getExpediteur().getSolde()) {
                msg = "On ne peut pas faire un retrait : Solde insuffisant";
            } else {
                Compte expediteur = transaction.getExpediteur();
                if (expediteur.getIdCompte() == null) {
                    expediteur = compteRepo.save(expediteur);
                    transaction.setExpediteur(expediteur);
                }
                msg = "Retrait de " + transaction.getMontant() + " DT de compte" + transaction.getExpediteur().getCode() + " approuvé avec succès.";
                transactionRepo.save(transaction);

            }
        }
        return msg;
    }

    @Override
    public String ajouterVersement(Transaction transaction) {
        String msg = "";

        if (transaction.getType() ==VERSEMENT) {
            Compte destinataire = transaction.getDestinataire();

            // Check if the destinataire is not an EPARGNE account
            if (destinataire.getType() != EPARGNE) {
                double montantVerse = transaction.getMontant() - 2.0;
                transaction.setMontant(montantVerse);

                // Save the updated transaction
                transactionRepo.save(transaction);

                msg = "Versement de " + montantVerse + " DT vers compte " + destinataire.getCode() + " approuvé avec succès.";
            } else {
                msg = "Le destinataire doit être un compte courant ou un compte épargne.";
            }
        } else {
            msg = "Le type de transaction doit être un versement.";
        }

        return msg;
    }

    @Scheduled(cron = "*/300 * * * * *") // Runs every 30 seconds
    public void getAllTransactionByDate() {
        LocalDate today = LocalDate.now();
        List<Transaction> transactions = transactionRepo.findByDateTransaction(today);
        log.info("Transactions for today:");
        for (Transaction transaction : transactions) {
            log.info(transaction.toString());
        }
    }

    @Override
    public List<Transaction> getAllTransactionByBankId(Long idBank){
        return transactionRepo.getTransactionsByBankId(idBank);
    }

    @Override
    public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, Long idCompte){
        List<Transaction> transactionsByExpediteur = transactionRepo.findByTypeAndExpediteur_IdCompte(type, idCompte);
        List<Transaction> transactionsByDestinataire = transactionRepo.findByTypeAndDestinataire_IdCompte(type, idCompte);

        // Combine or process both lists as needed
        List<Transaction> allTransactions = new ArrayList<>();
        allTransactions.addAll(transactionsByExpediteur);
        allTransactions.addAll(transactionsByDestinataire);

        return allTransactions;

    }

}
