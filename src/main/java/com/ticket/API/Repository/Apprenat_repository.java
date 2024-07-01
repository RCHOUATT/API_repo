package com.ticket.API.Repository;

import com.ticket.API.Enum.Roles;
import com.ticket.API.Module.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Apprenat_repository extends JpaRepository<Apprenant, Long>{
    Apprenant findByEmail(String email);
    List<Apprenant> findByRole(Roles role);
}
