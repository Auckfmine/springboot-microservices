package com.microservices.controllers;

import com.microservices.dto.ReglementDTO;
import com.microservices.services.interfaces.IReglementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/reglement")
public class ReglementController {

    private final IReglementService reglementService;
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "reglement-service is working fine !!! ";
    }


    @PostMapping("/add-reglement")
    @ResponseBody
    public ReglementDTO addReglement(@RequestBody ReglementDTO r) {
        return ReglementDTO.toDTO(reglementService.addReglement(ReglementDTO.toEntity(r)));
    }
    @GetMapping("/retrieve-all-reglements")
    @ResponseBody
    public Set<ReglementDTO> getReglement() {
        Set<ReglementDTO> reglements = new HashSet<>();
        reglementService
                .retrieveAllReglements()
                .forEach(reglement -> reglements.add(ReglementDTO.toDTO(reglement)));
        return reglements;
    }


    @GetMapping("/retrieve-reglement/{reglement-id}")
    @ResponseBody
    public ReglementDTO retrieveReglement(@PathVariable("reglement-id") Long reglementId) {
        return ReglementDTO.toDTO(reglementService.retrieveReglement(reglementId));
    }


    @GetMapping("/retrieveReglementByFacture/{facture-id}")
    @ResponseBody
    public List<ReglementDTO> retrieveReglementByFacture(@PathVariable("facture-id") Long factureId) {
        List<ReglementDTO> reglementParFacture = new ArrayList<>();
            reglementService
                    .retrieveReglementByFacture(factureId)
                    .forEach(reglement -> reglementParFacture.add(ReglementDTO.toDTO(reglement)));
        return reglementParFacture;
    }

    @GetMapping(value = "/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) throws Exception {
            return reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);

    }
}
