package com.microservices.controllers;

import com.microservices.dto.CategoryProduitDTO;
import com.microservices.services.interfaces.ICategoryProduitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/categorie-produit")
public class CategorieProduitController {
    private final ICategoryProduitService categoryProduitService;
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "categorie-produit-service is working fine !!! ";
    }

    @GetMapping("/retrieve-all-categorieProduit")
    @ResponseBody
    public Set<CategoryProduitDTO> getCategorieProduit() {
        Set<CategoryProduitDTO> list = new HashSet<>();
        categoryProduitService
                .retrieveAllCategorieProduits()
                .forEach(categoryProduit -> list.add(CategoryProduitDTO.toDto(categoryProduit)));
        return list;
    }

    @GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public CategoryProduitDTO retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        return CategoryProduitDTO.toDto(categoryProduitService.retrieveCategorieProduit(categorieProduitId));
    }

    @PostMapping("/add-categorieProduit")
    @ResponseBody
    public CategoryProduitDTO addCategorieProduit(@RequestBody CategoryProduitDTO cp) {
        return CategoryProduitDTO.toDto(categoryProduitService.addCategorieProduit(CategoryProduitDTO.toEntity(cp)));
    }

    @DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
    @ResponseBody
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categoryProduitService.deleteCategorieProduit(categorieProduitId);
    }

    // http://localhost:8089/SpringMVC/categorieProduit/modify-categorieProduit
    @PutMapping("/modify-categorieProduit")
    @ResponseBody
    public CategoryProduitDTO modifyCategorieProduit(@RequestBody CategoryProduitDTO categorieProduit) {
        return CategoryProduitDTO
                .toDto(categoryProduitService
                        .updateCategorieProduit(CategoryProduitDTO
                                .toEntity(categorieProduit)));
    }
}
