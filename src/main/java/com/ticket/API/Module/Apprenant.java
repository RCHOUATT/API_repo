package com.ticket.API.Module;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Apprenant extends Utilisateurs {

    @OneToMany(mappedBy = "apprenant",cascade = CascadeType.ALL )
    private List<Ticket> tickets;

}
