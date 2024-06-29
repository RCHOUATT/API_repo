package com.ticket.API.Controller;

import com.ticket.API.Module.*;
import com.ticket.API.Service.BaseDeConService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/BDCon")
@AllArgsConstructor
public class BDConController {

    private BaseDeConService baseDeConService;

    @PostMapping("/createBdCon")
    public BaseDeCon CreateBDCon (@RequestBody BaseDeCon baseDeCon) {
        return baseDeConService.CreateBaseDeCon(baseDeCon);
    }

    @PutMapping("/updateBDCon/{id}")
    public BaseDeCon UpdateBDCon(@PathVariable Long id,@RequestBody BaseDeCon baseDeCon){
        return baseDeConService.UpdateBaseDeCon(id,baseDeCon);
    }

    @DeleteMapping("/deleteBDCon/{id}")
    public String deleteBDCon(@PathVariable Long id){
        return baseDeConService.DeleteBaseDeCon(id);
    }

    @GetMapping("/AfficherBDCon/{id}")
    List<BaseDeCon> AfficherBDCon(@PathVariable Long id){
        return baseDeConService.GetBaseDeCon(id);
    }

}
