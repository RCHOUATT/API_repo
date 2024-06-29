package com.ticket.API.Module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Formateur extends Utilisateurs {

    @OneToMany(mappedBy = "formateur", cascade = CascadeType.ALL)
    private List<BaseDeCon> baseDeCon;

}
