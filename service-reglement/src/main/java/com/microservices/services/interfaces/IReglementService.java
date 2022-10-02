package com.microservices.services.interfaces;

import com.microservices.entities.Reglement;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IReglementService {
    Set<Reglement> retrieveAllReglements();
    Reglement addReglement(Reglement r);
    Reglement retrieveReglement(Long id);
    List<Reglement> retrieveReglementByFacture(Long idFacture);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) throws Exception;
}
