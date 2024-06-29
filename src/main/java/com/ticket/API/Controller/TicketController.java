package com.ticket.API.Controller;

import com.ticket.API.Module.*;
import com.ticket.API.Service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    @PostMapping("/createTicket")
    public Ticket CreerTicket(@RequestBody Ticket ticket) {
        return ticketService.CreerTicket(ticket);
    }

    @PutMapping("/updateTicket/{id}")
    public Ticket UpdateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.UpdateTicket(id, ticket);
    }

    @DeleteMapping("/delete/{id}")
    public String SupprimerTicket(@PathVariable Long id) {
        return ticketService.SupprimerTicket(id);
    }

    @GetMapping("/Afficher_Ticket")
    public List<Ticket> AfficherTicket() {
        return ticketService.AfficherTickets();
    }

    @GetMapping("/Ouvrir_ticket/{id}")
    public Optional<Ticket> OuvrirTicket(@PathVariable Long id) {
        return ticketService.OuvrirTicket(id);
    }

    @GetMapping("/Trier_ticket")
    public List<Ticket> TrierTicket(){
        return ticketService.TrierTicket();
    }


}
