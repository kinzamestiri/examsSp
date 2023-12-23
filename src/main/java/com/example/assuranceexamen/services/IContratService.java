package com.example.assuranceexamen.services;

import com.example.assuranceexamen.entities.Contrat;

public interface IContratService {
    Contrat ajouterContrat(Contrat c);

    Contrat getContratBf(int idBf);
}
