package com.ticket.API.Controller;

import com.ticket.API.Module.*;
import com.ticket.API.Service.ReponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reponse")
@AllArgsConstructor
@Tag(name ="ReponseController", description = "Solution apportée (à une question) par le raisonnement." )
public class ReponseController {

    private ReponseService reponseService;

    @Operation(description = "Ce point d'entré permet d'ajouter des reponses")
    @PostMapping("/createReponse/{id}")
    public Reponse createReponse (@PathVariable Long id, @RequestBody Reponse reponse) {
        return reponseService.Creerreponse(id, reponse);
    }

    @Operation(description = "Ce point d'entré permet de mettre à jour une reponse")
    @PutMapping("/updateReponse/{id}")
    public Reponse Updatereponse(@PathVariable Long id, @RequestBody Reponse reponse) {
        return reponseService.Updatereponse(id, reponse);
    }

    @Operation(description = "Ce point d'entré permet de supprimer une reponse")
    @DeleteMapping("/deleteReponse/{id}")
    public String Supprimerreponse(@PathVariable Long id) {
        return reponseService.Supprimerreponse(id);
    }

    @Operation(description = "Ce point d'entré permet d'affciher des reponses")
    @GetMapping("/AfficherReponse")
    public List<Reponse> Afficherreponse() {
        return reponseService.Afficherreponse();
    }

}
