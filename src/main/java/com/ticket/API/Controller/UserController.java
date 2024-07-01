package com.ticket.API.Controller;

import com.ticket.API.Module.Admin;
import com.ticket.API.Module.Apprenant;
import com.ticket.API.Module.Formateur;
import com.ticket.API.Module.Utilisateurs;
import com.ticket.API.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name ="Userontroller", description = "Les utilisateurs sont ceux qui utilisent le systemes. C'est à dire les acteurs." +
        "Ce sont les AMINS, les FORMATEURS, les APPRENANTS")

public class UserController {

    private UserService userService;

    @Operation(description = "Ce point d'entré permet d'ajouter un utilisateur avec un role formateur")
    @PostMapping("/createFormateur")
    public Formateur CreateFormateur (@RequestBody Formateur formateur) {
        return userService.CreateFormateur(formateur);
    }

    @Operation(description = "Ce point d'entré permet d'ajouter un utilisateur avec un role apprenant")
    @PostMapping("/createApprenant")
    public Apprenant CreateApprenant(@RequestBody Apprenant apprenant) {
        return userService.CreateApprenant(apprenant);
    }

    @Operation(description = "Ce point d'entré permet d'ajouter un utilisateur avec un role admin")
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

    @Operation(description = "Ce point d'entré permet d'affciher un utilisateur")
    @GetMapping("/Afficher_user/{id}")
    Optional<Utilisateurs> GetUser(@PathVariable Long id){
        return userService.GetUser(id);
    }

    @Operation(description = "Ce point d'entré permet d'affciher des utilisateurs")
    @GetMapping("/Afficher_users")
    public List<Utilisateurs> GetAllUsers(){
        return userService.GetAllUsers();
    }

}
