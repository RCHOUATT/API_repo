package com.ticket.API.Service;

import com.ticket.API.Module.BaseDeCon;
import com.ticket.API.Module.Formateur;
import com.ticket.API.Repository.BaseCon_repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseDeConServiceImpl implements BaseDeConService{

    private BaseCon_repository baseCon_repository;

    @Override
    public BaseDeCon CreateBaseDeCon(BaseDeCon baseDeCon) {
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
}
