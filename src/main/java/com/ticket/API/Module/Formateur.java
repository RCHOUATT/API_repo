package com.ticket.API.Module;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Formateur extends Utilisateurs {

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<BaseDeCon> baseDeCon;

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<Reponse> reponse;

}
