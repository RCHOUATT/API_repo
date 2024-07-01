package com.ticket.API.Controller;

import com.ticket.API.Module.*;
import com.ticket.API.Service.BaseDeConService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/BDCon")
@AllArgsConstructor
@Tag(name ="BCController", description = "Une base de connaissance " +
        "regroupe des connaissances spécifiques à un domaine spécialisé donné, sous une forme. " +
        "Ce sont des reponses aux questions frequentes posées par les apprenants. C'est le formateur qui repond à ces questions.")
public class BDConController {

    private BaseDeConService baseDeConService;

    @Operation(description = "Ce point d'entré permet d'ajouter des données à la base de connaissance")
    @PostMapping("/createBdCon")
    public BaseDeCon CreateBDCon (@RequestBody BaseDeCon baseDeCon) {
        return baseDeConService.CreateBaseDeCon(baseDeCon);
    }

    @Operation(description = "Ce point d'entré permet de mettre à jour une donnée de la base de connaissance")
    @PutMapping("/updateBDCon/{id}")
    public BaseDeCon UpdateBDCon(@PathVariable Long id,@RequestBody BaseDeCon baseDeCon){
        return baseDeConService.UpdateBaseDeCon(id,baseDeCon);
    }

    @Operation(description = "Ce point d'entré permet de supprimer une donnée de la base de connaissance")
    @DeleteMapping("/deleteBDCon/{id}")
    public String deleteBDCon(@PathVariable Long id){
        return baseDeConService.DeleteBaseDeCon(id);
    }

    @Operation(description = "Ce point d'entré permet d'afficher les données de la base de connaissance")
    @GetMapping("/AfficherBDCon/{id}")
    List<BaseDeCon> AfficherBDCon(@PathVariable Long id){
        return baseDeConService.GetBaseDeCon(id);
    }

}
