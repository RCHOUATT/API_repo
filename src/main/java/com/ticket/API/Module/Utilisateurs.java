package com.ticket.API.Module;

import com.ticket.API.Enum.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Utilisateurs{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
}
