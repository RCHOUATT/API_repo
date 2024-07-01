package com.ticket.API.Repository;

import com.ticket.API.Enum.Roles;
import com.ticket.API.Module.Apprenant;
import com.ticket.API.Module.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Formateur_repository extends JpaRepository<Formateur, Long>{
    Formateur findByEmail(String email);
    List<Formateur> findByRole(Roles role);
}
