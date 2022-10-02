package com.microservices.dto;

import com.microservices.entities.Stock;
import com.microservices.exceptions.ResourceNotFoundException;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StockDto {
    private Long id;
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;

    //map dto to entity
    public static Stock toEntity(StockDto dto){
        if(dto==null){
            throw  new ResourceNotFoundException("les données entrées ne sont pas valide");
        }
        return Stock.builder()
                .id(dto.id)
                .libelleStock(dto.libelleStock)
                .qteMin(dto.qteMin)
                .qte(dto.qte)
                .build();
    }

    //map entity to dto
    public static StockDto toDto(Stock stock){
        if(stock==null){
            throw new ResourceNotFoundException("les données entrées ne sont pas valide");

        }
        return StockDto
                .builder()
                .id(stock.getId())
                .libelleStock(stock.getLibelleStock())
                .qte(stock.getQte())
                .qteMin(stock.getQteMin())
                .build();
    }
}
