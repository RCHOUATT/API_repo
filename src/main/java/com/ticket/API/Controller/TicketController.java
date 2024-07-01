package com.ticket.API.Controller;

import com.ticket.API.Module.*;
import com.ticket.API.Service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
@Tag(name ="ControllerTicket", description = "Le système de tickets permet aux formateurs de prioriser les demandes en fonction de leur urgence et de leur importance, garantissant ainsi une gestion du temps plus efficace.\n" +
        "\n" +
        "Il permet aux apprenants de recevoir des conseils et une assistance adaptés à leurs besoins spécifiques.\n" +
        "\n" +
        "Il permet egalement de garder une trace des interactions entre les formateurs et les apprenants pour mieux suivre l'évolution de chaque participant.\n")
public class TicketController {

    private TicketService ticketService;

    @Operation(description = "Ce point d'entré permet d'ajouter des tickets")
    @PostMapping("/createTicket")
    public Ticket CreerTicket(@RequestBody Ticket ticket) {
        return ticketService.CreerTicket(ticket);
    }

    @Operation(description = "Ce point d'entré permet de mettre à jour un ticket")
    @PutMapping("/updateTicket/{id}")
    public Ticket UpdateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.UpdateTicket(id, ticket);
    }

    @Operation(description = "Ce point d'entré permet de supprimer un ticket")
    @DeleteMapping("/delete/{id}")
    public String SupprimerTicket(@PathVariable Long id) {
        return ticketService.SupprimerTicket(id);
    }

    @Operation(description = "Ce point d'entré permet d'affciher des tickets")
    @GetMapping("/Afficher_Tickets")
    public List<Ticket> AfficherTicket() {
        return ticketService.AfficherTickets();
    }

    @GetMapping("/Ouvrir_ticket/{id}")
    public Optional<Ticket> OuvrirTicket(@PathVariable Long id) {
        return ticketService.OuvrirTicket(id);
    }

    @Operation(description = "Ce point d'entré permet de trier des tickets")
    @GetMapping("/Trier_ticket")
    public List<Ticket> TrierTicket(){
        return ticketService.TrierTicket();
    }


}
