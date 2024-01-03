package com.example.assuranceexamen.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
    private double montant;
    private LocalDate dateTransaction;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;

    @ManyToOne(cascade = CascadeType.ALL)
    Compte expediteur;

    @ManyToOne(cascade = CascadeType.ALL)
    Compte destinataire;

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", montant=" + montant +
                ", dateTransaction=" + dateTransaction +
                ", type=" + type +
                ", expediteur=" + expediteur +
                ", destinataire=" + destinataire +
                '}';
    }
}
