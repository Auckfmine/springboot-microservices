package com.microservices.controllers;

import com.microservices.dto.ProduitDto;
import com.microservices.services.interfaces.IProduitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
@Slf4j
public class ProduitController {
    private final IProduitService service;
    @GetMapping("/test")
    @ResponseBody

    public String TestController(){
        return "produit-service is working fine !!! ";
    }


    @PostMapping("/add-produit")
    @ResponseBody
    public ProduitDto addProduit(@RequestBody ProduitDto produitDto){
        return ProduitDto.toDto(service.addProduit(ProduitDto.toEntity(produitDto)));
    }
    @GetMapping("/{idProduit}")
    @ResponseBody
    public ProduitDto retrieveProduit(@PathVariable("idProduit")Long idProduit){
        return ProduitDto.toDto(service.retrieveProduit(idProduit));
}
    @PatchMapping("/update-produit")
    @ResponseBody
    public ProduitDto updateProduit(@RequestBody ProduitDto produitDto){
        return ProduitDto.toDto(service.updateProduit(ProduitDto.toEntity(produitDto)));
    }

    @DeleteMapping("/delete-produit/{idProduit}")
    @ResponseBody
    public void deleteProduit(@PathVariable("idProduit") Long idProduit){
        service.deleteProduit(idProduit);
    }

    @GetMapping("/assign-produit-stock/{idProduit}/{idStock}")
    @ResponseBody
    public void assignProduitToStock(@PathVariable("idProduit")Long idProduit,@PathVariable("idStock") Long idStock){
        service.assignProduitToStock(idProduit, idStock);
    }
}
