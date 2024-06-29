package com.ticket.API.Repository;

import com.ticket.API.Module.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Ticket_repository extends JpaRepository<Ticket, Long>{

}
