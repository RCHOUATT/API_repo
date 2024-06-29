package com.ticket.API.Service;

import com.ticket.API.Module.Admin;
import com.ticket.API.Module.Apprenant;
import com.ticket.API.Module.Formateur;
import com.ticket.API.Module.Utilisateurs;
import com.ticket.API.Repository.User_repository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private User_repository user_repository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Formateur CreateFormateur(Formateur formateur) {
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
        return user_repository.save(formateur);
    }

    @Override
    public Admin CreateAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return user_repository.save(admin);
    }

    @Override
    public Apprenant CreateApprenant(Apprenant apprenant) {
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        return user_repository.save(apprenant);
    }

    @Override
    public Utilisateurs UpdateUser(Long id, Utilisateurs utilisateur) {
        return user_repository.findById(id)
                .map(p->{
                    p.setNom(utilisateur.getNom());
                    p.setEmail(utilisateur.getEmail());
                    p.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
                    p.setRole(utilisateur.getRole());
                    return user_repository.save(p);
                }).orElseThrow(()-> new RuntimeException("Nous n'avons pas pu mettre à jour vos information," +
                        " veuillez réessayez une nouvelle fois"));
    }

    @Override
    public String DeleteUtilisateur(Long id) {
        user_repository.deleteById(id);
        return "Utilisateur " + id + " supprimé avec succès";
    }

    @Override
    public Optional<Utilisateurs> GetUser(Long id) {
        return user_repository.findById(id);
    }


    @Override
    public List<Utilisateurs> GetAllUsers() {
        return user_repository.findAll();
    }

}
