package com.ticket.API.Service;

import com.ticket.API.Module.Notification;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotifServiceImpl implements NotifService {
    private final JavaMailSender mailSender;


    public NotifServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Notification notification) throws MessagingException {
        String content = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<style>" +
                ".email-body { font-family: 'Arial', sans-serif; max-width: 600px; margin: auto; }" +
                ".header { background-color: #f3f3f3; padding: 20px; }" +
                ".content { padding: 20px; }" +
                ".cta-button { display: block; width: 200px; margin: 20px auto; padding: 10px; background-color: #007bff; color: white; text-align: center; text-decoration: none; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"email-body\">" +
                "<div class=\"header\"> " + notification.getNotif_subject() + " </div>" +
                "<div class=\"content\"> " + notification.getNotif_body() + "</div>" +
                "<a href=\"https://www.example.com\" class=\"cta-button\">Learn More</a>" +
                "</div>" +
                "</body>" +
                "</html>";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(notification.getDest_email());
        helper.setSubject(notification.getNotif_subject());
        helper.setText(content, true); // true indicates HTML content
        mailSender.send(message);
    }
}
