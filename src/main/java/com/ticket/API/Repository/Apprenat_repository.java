package com.ticket.API.Repository;

import com.ticket.API.Enum.Roles;
import com.ticket.API.Module.Apprenant;
import com.ticket.API.Module.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Apprenat_repository extends JpaRepository<Apprenant, Long>{
    Apprenant findByEmail(String email);
    List<Apprenant> findByRole(Roles role);
}
