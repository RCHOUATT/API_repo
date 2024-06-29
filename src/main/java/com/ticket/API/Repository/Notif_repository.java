package com.ticket.API.Repository;

import com.ticket.API.Module.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface Notif_repository extends JpaRepository<Notification, Long>{

}
