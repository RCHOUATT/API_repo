package com.ticket.API.Repository;

import com.ticket.API.Module.BaseDeCon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BaseCon_repository extends JpaRepository<BaseDeCon, Long>{
}
