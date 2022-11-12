package com.microservices.entities;

import com.microservices.entities.Base.AbstractEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Slf4j
public class Produit extends AbstractEntity {

    private String codeProduit;
    private String libelleProduit;
    private Float prix;
    private Long idStock;


}
