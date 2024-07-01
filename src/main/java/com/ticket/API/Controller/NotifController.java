package com.ticket.API.Controller;

import com.ticket.API.Module.Notification;
import com.ticket.API.Service.NotifService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notif")
@AllArgsConstructor
@Tag(name ="Notification", description = "La notification fait référence à un document écrit qui est destiné" +
        " à informer une personne d'une règlementation, ou d'une information légale importante.")
public class NotifController {

    private NotifService notifService;

    @Operation(description = "Ce point d'entré permet d'envoyer une notification")
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Notification notification) throws MessagingException {
        //String subject = "New Product Launch: Smart Wearable Fitness Tracker";

        notifService.sendEmail(notification);
        return "Email sent successfully";
    }
}

