package com.microservices.services.implementation;

import com.microservices.entities.Reglement;
import com.microservices.exceptions.ResourceNotFoundException;
import com.microservices.repositories.IReglementRepository;
import com.microservices.services.interfaces.IReglementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceReglementImpl implements IReglementService {

    private final IReglementRepository repository;

    @Override
    public Set<Reglement> retrieveAllReglements() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Reglement addReglement(Reglement r) {
        return repository.save(r);
    }

    @Override
    public Reglement retrieveReglement(Long id) {
        return repository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("reglement avec id : "+id+" est introuvable"));
    }

    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {
        return repository.findByIdFacture(idFacture);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) throws Exception {
        try {
            return repository.getChiffreAffaireEntreDeuxDate(startDate,endDate);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
