package com.ticket.API.Service;

import com.ticket.API.Module.Admin;
import com.ticket.API.Module.Apprenant;
import com.ticket.API.Module.Formateur;
import com.ticket.API.Module.Utilisateurs;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //Les methodes pour creer un des utilisateur.
    Formateur CreateFormateur(Formateur formateur);
    Admin CreateAdmin(Admin admin);
    Apprenant CreateApprenant(Apprenant apprenant);

    //Les methodes pour mettre à jour un des utilisateur.
    Utilisateurs UpdateUser(Long id, Utilisateurs utilisateur);

    //Les methodes pour supprimer un utilisateur.
    String DeleteUtilisateur(Long id);

    //Les methodes pour Afficher un ou plusieurs utilisateurs.
    Optional<Utilisateurs> GetUser(Long id);
    List<Utilisateurs> GetAllUsers();
}
