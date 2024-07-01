package com.ticket.API.Service;

import com.ticket.API.Module.*;

import java.util.List;
import java.util.Optional;

public interface BaseDeConService {

    //La methode pour creer une base de connaissance.
    BaseDeCon CreateBaseDeCon(BaseDeCon baseDeCon);

    //Les methodes pour mettre à jour une base de connaissance.
    BaseDeCon UpdateBaseDeCon(Long id, BaseDeCon baseDeCon);

    //Les methodes pour supprimer une base de connaissance.
    String DeleteBaseDeCon(Long id);

    //Les methodes pour Afficher une base de connaissance.
    List<BaseDeCon> GetBaseDeCon(Long id);

    //Les methodes pour Afficher les bases de connaissance.
    List<BaseDeCon> GetBaseDeCons();
}
