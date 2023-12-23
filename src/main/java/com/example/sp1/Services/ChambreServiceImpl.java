package com.example.sp1.Services;

import com.example.sp1.Repositories.BlocRepo;
import com.example.sp1.Repositories.ChambreRepo;
import com.example.sp1.entities.Chambre;
import com.example.sp1.entities.TypeChambre;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService {
    //instance
    ChambreRepo chambreRepo;
    BlocRepo blocRepo;
    @Override
    public List<Chambre> retrieveAllChambres(){
        return chambreRepo.findAll();
    }
    @Override
    public Chambre addChambre(Chambre c){
        //ajouter une description sur l'etat de la fonction
        System.out.println("ajouter"+c.toString());
        log.info("on a ajouté une chambre"+c.toString());
        return chambreRepo.save(c);
    }
    @Override
    public Chambre updateChambre(Chambre c){
        return chambreRepo.save(c);
    }
    @Override
    public Chambre retrieveChambre(long idChambre){
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre>  getChambresParNomUniversite(String nomUniversite) {
        return chambreRepo.findChambresByBloc_Foyer_Universite_NomUniversite(nomUniversite);
    }
    @Override
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) {
        return chambreRepo.findChambresByBloc_IdBlocAndTypeC(idBloc,typeC);
    }

   @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomUniversite, TypeChambre typeC) {
        return chambreRepo.findAllByReservationsIsEmptyAndBloc_Foyer_Universite_NomUniversiteAndTypeC(nomUniversite,typeC);
    }


   // @Scheduled(fixedRate = 5000)
   // @Scheduled(fixedDelay = 5000)
   // @Scheduled(cron="* 10 5 * * *")//chaque seconde de la 10eme minutes,5eme heure de chaque jour,mois de la semaine
    //@Scheduled(cron="1 10 5 * * *")//une seule fois
    @Scheduled(cron="*/5 * * * * *")//toutes les 5secondes 0[5]
    public void testScheduler()  {
      // 1:fixed rate log.info("test scheduling fixedRate");
        //CompletableFuture.delayedExecutor(5, TimeUnit.SECONDS).execute(()-> log.info("test scheduling fixedDelay"));
       //2:fixed delay log.info("test scheduling fixedDelays");
       // TimeUnit.SECONDS.sleep(5);


    }
    /*List<Chambre> getChambreByReservationAnneeUniversitaire(Date debut,Date fin){
        List<Chambre> chambres=null;
        for (Chambre c: chambreRepo.findAll())
            for (Reservation r:c.getReservations())
                if (r.getAnneeUniversitaire().after(debut)&& r.getAnneeUniversitaire().before(fin))
                    chambres.add(c);
        return chambres;
    }*/
}
