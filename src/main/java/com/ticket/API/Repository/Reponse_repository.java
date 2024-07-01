package com.ticket.API.Repository;

import com.ticket.API.Module.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Reponse_repository extends JpaRepository<Reponse, Long>{

}
