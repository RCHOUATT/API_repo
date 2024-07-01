package com.ticket.API.Service;

import com.ticket.API.Enum.Roles;
import com.ticket.API.Enum.StatutTicket;
import com.ticket.API.Module.*;
import com.ticket.API.Repository.Apprenat_repository;
import com.ticket.API.Repository.Notif_repository;
import com.ticket.API.Repository.Ticket_repository;
import com.ticket.API.Repository.User_repository;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private Ticket_repository ticket_repository;
    private User_repository user_repository;
    private Apprenat_repository apprenat_repository;
    private NotifService notifService;
    private Notif_repository notif_repository;

    public String getConnectedUser_usename() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            return user_repository.findByEmail(username).get().getNom();
        } else {
            username = principal.toString();
        }
        return user_repository.findByEmail(username).get().getNom();
    }

    public Apprenant getConnectedApprenant() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            return apprenat_repository .findByEmail(username);
        } else {
            username = principal.toString();
        }
        return apprenat_repository.findByEmail(username);
    }

    /*public String getConnectedUser_id() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id;
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            id = String.valueOf(user_repository.findByEmail(username).get().getId());
            return id;
        } else {
            id = principal.toString();
        }

        return id;
    }*/

    @Override
    public Ticket CreerTicket(Ticket ticket) {
        List<Utilisateurs> utilisateurs = user_repository.findByRole(Roles.FORMATEUR);
        Notification notification = new Notification();
        utilisateurs.forEach(p->{
            notification.setTicket(ticket);
            notification.setNotif_body("Vous avez reçu un nouveau ticket de la part de " + getConnectedUser_usename());
            notification.setDest_email((p.getEmail()));
            notification.setNotif_subject("A new ticket has been created");
            try {
                notifService.sendEmail(notification);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });
        ticket.setApprenant(getConnectedApprenant());
        ticket.setStatut(StatutTicket.ENVOYER);
        ticket.setMiseAJ(new Date());
        Ticket newTicket = ticket_repository.save(ticket);
        notification.setTicket(ticket);
        notif_repository.save(notification);
        return newTicket;
    }

    @Override
    public Ticket UpdateTicket(Long id, Ticket ticket) {
        Notification notification = new Notification();
        List<Utilisateurs> utilisateurs = user_repository.findByRole(Roles.FORMATEUR);
        utilisateurs.forEach(p->{
            notification.setTicket(ticket);
            notification.setNotif_body("Le ticket N° " + id + " a été modifié ");
            notification.setDest_email((p.getEmail()));
            notification.setNotif_subject("Modification d'un ticket");
            try {
                notifService.sendEmail(notification);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });

        return ticket_repository.findById(id)
                .map(p->{
                    p.setApprenant(getConnectedApprenant());

                    if(ticket.getQuestion() != null){
                        p.setQuestion(ticket.getQuestion());}

                    if(ticket.getCategory() != null){
                        p.setCategory(ticket.getCategory());}

                    if(ticket.getTitre() != null) {
                        p.setTitre(ticket.getTitre());
                    }
                    if(ticket.getStatut() != null) {
                        p.setStatut(ticket.getStatut());
                    }
                    p.setMiseAJ(new Date());
                    Ticket updateTicket = ticket_repository.save(p);
                    notification.setTicket(ticket);
                    notif_repository.save(notification);
                    return updateTicket;
                }).orElseThrow(()->new RuntimeException("La ticket " + id + " n'existe pas"));
    }

    @Override
    public String SupprimerTicket(Long id) {
        List<Utilisateurs> utilisateurs = user_repository.findByRole(Roles.FORMATEUR);
        Optional<Ticket> ticket = ticket_repository.findById(id);
        Notification notification = new Notification();
        utilisateurs.forEach(p->{
            notification.setTicket(ticket.orElseThrow());
            notification.setNotif_body("Le ticket N° " + id + " a été supprimé ");
            notification.setDest_email((p.getEmail()));
            notification.setNotif_subject("Suppréssion d'un Ticket");
            try {
                notifService.sendEmail(notification);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });
        ticket_repository.deleteById(id);
        notification.setTicket(ticket.get());
        notif_repository.save(notification);
        return "La ticket " + id + " n'existe pas";
    }

    @Override
    public List<Ticket> AfficherTickets() {
        return ticket_repository.findAll();
    }

    @Override
    public Optional<Ticket> OuvrirTicket(Long id) {

            Notification notification = new Notification();
            notification.setTicket(ticket_repository.findById(id).orElseThrow());
            notification.setNotif_body("Le ticket N° " + id + "a été Ouvert ");
            notification.setDest_email((ticket_repository.findById(id).get().getApprenant().getEmail()));
            notification.setNotif_subject("Ouverture d'un tifcket");
            try {
                notifService.sendEmail(notification);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        return ticket_repository.findById(id);
    }

    @Override
    public List<Ticket> TrierTicket() {
        return ticket_repository.findAll(Sort.by(Sort.Direction.ASC, "statut"));
    }
}
