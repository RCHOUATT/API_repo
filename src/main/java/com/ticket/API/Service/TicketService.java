package com.ticket.API.Service;

import com.ticket.API.Module.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    //La methode pour creer un ticket.
    Ticket CreerTicket(Ticket ticket);

    //La methode pour mettre à jour un ticket.
    Ticket UpdateTicket(Long id, Ticket ticket);

    //La methode pour supprimer un ticket.
    String SupprimerTicket(Long id);

    //La methode pour Afficher un ticket.
    List<Ticket> AfficherTickets();

    Optional<Ticket> OuvrirTicket(Long id);

    //La methode pour trier un ticket.
    List<Ticket> TrierTicket();

}
