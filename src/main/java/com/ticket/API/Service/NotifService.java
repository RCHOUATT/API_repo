package com.ticket.API.Service;

import com.ticket.API.Module.Notification;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface NotifService {
    void sendEmail(Notification notification) throws MessagingException;
}
