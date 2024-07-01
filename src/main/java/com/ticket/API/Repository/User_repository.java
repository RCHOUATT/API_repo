package com.ticket.API.Repository;

import com.ticket.API.Enum.Roles;
import com.ticket.API.Module.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface User_repository extends JpaRepository<Utilisateurs, Long>{
    Optional<Utilisateurs> findByEmail(String email);
    List<Utilisateurs> findByRole(Roles role);

}
