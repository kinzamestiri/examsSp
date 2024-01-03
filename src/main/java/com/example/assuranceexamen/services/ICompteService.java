package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Compte;

public interface ICompteService {
    Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
}
