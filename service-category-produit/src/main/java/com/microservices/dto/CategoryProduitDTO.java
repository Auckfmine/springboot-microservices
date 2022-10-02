package com.microservices.dto;

import com.microservices.entities.CategoryProduit;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryProduitDTO {
    private Long id;
    private String codeCategorie;
    private String libelleCategorie;

    //map Entity To DTO
    public static CategoryProduitDTO toDto(CategoryProduit categoryProduit){
        return CategoryProduitDTO
                .builder()
                .id(categoryProduit.getId())
                .codeCategorie(categoryProduit.getCodeCategorie())
                .libelleCategorie(categoryProduit.getLibelleCategorie())
                .build();
    }
    // map DTO to Entity

    public static CategoryProduit toEntity(CategoryProduitDTO categoryProduitDTO){
        return CategoryProduit
                .builder()
                .id(categoryProduitDTO.id)
                .libelleCategorie(categoryProduitDTO.libelleCategorie)
                .codeCategorie(categoryProduitDTO.codeCategorie)
                .build();
    }
}
