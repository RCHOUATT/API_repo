package com.ticket.API.Module;

import com.ticket.API.Enum.CategoryTicket;
import com.ticket.API.Enum.StatutTicket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    private String titre;
    private String question;

    @Enumerated(EnumType.STRING)
    private StatutTicket statut;

    @Enumerated(EnumType.STRING)
    private CategoryTicket category;

    private Date creationDate = new Date();
    private Date miseAJ;

    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Reponse responses;
}
