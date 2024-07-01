package com.ticket.API.Service;

import com.ticket.API.Module.Reponse;
import com.ticket.API.Module.Ticket;

import java.util.List;
import java.util.Optional;

public interface ReponseService {

    //La methode pour creer une reponse.
    Reponse Creerreponse(Long id,Reponse reponse);

    //La methode pour mettre à jour une reponse.
    Reponse Updatereponse(Long id, Reponse reponse);

    //La methode pour supprimer une reponse.
    String Supprimerreponse(Long id);

    //La methode pour Afficher une reponse.
    List<Reponse> Afficherreponse();


}
