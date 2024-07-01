package com.ticket.API.Service;

import com.ticket.API.Module.BaseDeCon;
import com.ticket.API.Module.Formateur;
import com.ticket.API.Repository.BaseCon_repository;
import com.ticket.API.Repository.Formateur_repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseDeConServiceImpl implements BaseDeConService{

    private BaseCon_repository baseCon_repository;
    private Formateur_repository formateur_repository;

    public Formateur getConnectedUser_usename() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            return formateur_repository.findByEmail(username);
        } else {
            username = principal.toString();
        }
        return formateur_repository.findByEmail(username);
    }

    @Override
    public BaseDeCon CreateBaseDeCon(BaseDeCon baseDeCon) {
        baseDeCon.setFormateur(getConnectedUser_usename());
        return baseCon_repository.save(baseDeCon);
    }

    @Override
    public BaseDeCon UpdateBaseDeCon(Long id, BaseDeCon baseDeCon) {
        return baseCon_repository.findById(id)
                .map(p->{
                    p.setFormateur((Formateur)baseDeCon.getFormateur());
                    p.setQuestion(baseDeCon.getQuestion());
                    p.setReponse(baseDeCon.getReponse());
                    return baseCon_repository.save(p);
                }).orElseThrow(()->new RuntimeException("Base de con id " + id + " no existe"));
    }

    @Override
    public String DeleteBaseDeCon(Long id) {
        baseCon_repository.deleteById(id);
        return "Base de con id " + id + " supprimé avec success";
    }

    @Override
    public List<BaseDeCon> GetBaseDeCon(Long id) {
        return List.of();
    }

    @Override
    public List<BaseDeCon> GetBaseDeCons() {
        return baseCon_repository.findAll();
    }
}
