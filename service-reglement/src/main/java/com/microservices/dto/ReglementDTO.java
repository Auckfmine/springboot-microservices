package com.microservices.dto;

import com.microservices.entities.Reglement;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Builder
@Data
public class ReglementDTO {
    private Long id;
    private float montantPaye;
    private float montantRestant;
    private Boolean payee;
    private Date dateReglement;
    private Long idFacture;


    //map Entity to DTO
    public static ReglementDTO toDTO(Reglement reglement){
        if(reglement==null){
            throw new IllegalArgumentException("object reglement n'est pas valide");
        }
        return ReglementDTO
                .builder()
                .id(reglement.getId())
                .montantPaye(reglement.getMontantPaye())
                .montantRestant(reglement.getMontantRestant())
                .payee(reglement.getPayee())
                .dateReglement(reglement.getDateReglement())
                .idFacture(reglement.getIdFacture())
                .build();
    }
    // map DTO to Entity
    public static Reglement toEntity(ReglementDTO dto){
        if(dto==null){
            throw new IllegalArgumentException("object reglement n'est pas valide");

        }
        return Reglement
                .builder()
                .id(dto.id)
                .montantPaye(dto.montantPaye)
                .montantRestant(dto.montantRestant)
                .payee(dto.payee)
                .dateReglement(dto.dateReglement)
                .idFacture(dto.idFacture)
                .build();
    }
}
