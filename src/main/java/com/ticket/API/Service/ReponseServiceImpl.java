package com.ticket.API.Service;

import com.ticket.API.Module.*;
import com.ticket.API.Repository.Formateur_repository;
import com.ticket.API.Repository.Reponse_repository;
import com.ticket.API.Repository.Ticket_repository;
import com.ticket.API.Repository.User_repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReponseServiceImpl implements ReponseService {

    private Reponse_repository reponse_repository;
    private Ticket_repository ticket_repository;
    private Formateur_repository formateur_repository;

    public Formateur getConnectedUser_usename() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            return formateur_repository.findByEmail(username);
        } else {
            username = principal.toString();
        }
        return formateur_repository.findByEmail(username);
    }

    @Override
    public Reponse Creerreponse(Long id, Reponse reponse) {
        Optional<Ticket> ticket = ticket_repository.findById(id);
        reponse.setTicket(ticket.get());
        reponse.setFormateur(getConnectedUser_usename());
        return reponse_repository.save(reponse);
    }

    @Override
    public Reponse Updatereponse(Long id, Reponse reponse) {
        return reponse_repository.findById(id)
                .map(p->{
                    p.setReponse(reponse.getReponse());
                    return reponse_repository.save(p);
                }).orElseThrow(()->new RuntimeException("Reponse n'existe pas"));
    }

    @Override
    public String Supprimerreponse(Long id) {
        reponse_repository.deleteById(id);
        return "Reponse supprimer avec succes";
    }

    @Override
    public List<Reponse> Afficherreponse() {
        return reponse_repository.findAll();
    }
}
