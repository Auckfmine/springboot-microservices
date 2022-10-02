package com.microservices.dto;

import com.microservices.entities.Produit;
import com.microservices.exceptions.ResourceNotFoundException;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProduitDto {
    private Long id;
    private String codeProduit;
    private String libelleProduit;
    private Float prix;
    private Long idStock;
    private Long idCategory;

    //map dto to entity
    public static Produit toEntity(ProduitDto dto){
        if(dto==null){
            throw  new ResourceNotFoundException("les données entrées ne sont pas valide");
        }
        return Produit.builder()
                .id(dto.id)
                .idCategory(dto.idStock)
                .prix(dto.prix)
                .libelleProduit(dto.libelleProduit)
                .codeProduit(dto.codeProduit)
                .idStock(dto.idStock)
                .build();
    }

    //map entity to dto
    public static ProduitDto toDto(Produit produit){
        if(produit==null){
            throw new ResourceNotFoundException("les données entrées ne sont pas valide");

        }
        return ProduitDto
                .builder()
                .id(produit.getId())
                .codeProduit(produit.getCodeProduit())
                .libelleProduit(produit.getLibelleProduit())
                .idCategory(produit.getIdCategory())
                .idStock(produit.getIdStock())
                .prix(produit.getPrix())
                .build();
    }
}
