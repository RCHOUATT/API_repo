package com.ticket.API.Controller;

import com.ticket.API.Module.Admin;
import com.ticket.API.Module.Apprenant;
import com.ticket.API.Module.Formateur;
import com.ticket.API.Module.Utilisateurs;
import com.ticket.API.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/createFormateur")
    public Formateur CreateFormateur (@RequestBody Formateur formateur) {
        return userService.CreateFormateur(formateur);
    }
    @PostMapping("/createApprenant")
    public Apprenant CreateApprenant(@RequestBody Apprenant apprenant) {
        return userService.CreateApprenant(apprenant);
    }
    @PostMapping("/createAdmin")
    public Admin CreateAdmin(@RequestBody Admin admin) {
        return userService.CreateAdmin(admin);
    }

    @PutMapping("/update/{id}")
    public Utilisateurs UpdateUser(@PathVariable Long id,@RequestBody Utilisateurs utilisateur){
        return userService.UpdateUser(id, utilisateur);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteUtilisateur(@PathVariable Long id){
        return userService.DeleteUtilisateur(id);
    }

    @GetMapping("/Afficher_user/{id}")
    Optional<Utilisateurs> GetUser(@PathVariable Long id){
        return userService.GetUser(id);
    }

    @GetMapping("/Afficher_users")
    public List<Utilisateurs> GetAllUsers(){
        return userService.GetAllUsers();
    }

}
