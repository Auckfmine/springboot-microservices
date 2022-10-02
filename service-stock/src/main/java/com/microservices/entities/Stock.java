package com.microservices.entities;

import com.microservices.entities.Base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class Stock extends AbstractEntity {
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;
}
