package com.microservices.services.implementation;

import com.microservices.entities.Produit;
import com.microservices.exceptions.ResourceNotFoundException;
import com.microservices.repositories.IProduitRepository;
import com.microservices.services.interfaces.IProduitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitServiceImpl implements IProduitService {

    private final IProduitRepository repository;

    @Override
    public Set<Produit> retrieveAllProduits() {
        return new HashSet<>(repository.findAll());
    }

    @Override
    public Produit addProduit(Produit p) {
        log.info("produit : {}",p);
        log.info("in method addProduit of ProduitService");
        Produit produit = Produit.builder()
                .codeProduit(p.getCodeProduit())
                .libelleProduit(p.getLibelleProduit())
                .prix(p.getPrix())
                .idStock(null)
                .build();
        log.info(" in method addProduit : product created successfully !");
        return repository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        log.info("in method deleteProduit of ProduitService");
        repository.findById(id)
                .map(produit -> {
                    repository.deleteById(id);
                    log.info("produit : "+produit.getLibelleProduit()+" supprimé avec succes");
                    return produit;
                })
                .orElseThrow(() -> new ResourceNotFoundException("produit avec id : " + id + "n'existe pas dans la bd"));
    }
    @Override
    public Produit updateProduit(Produit p) {
        log.info("in method updateProduit of ProduitService");
        return repository.save(p);
    }


    @Override
    public Produit retrieveProduit(Long id) {
        log.info("in method retrieveProduit of ProduitService");
        return repository.findById(id)
                .map(produit ->{
                    log.info("in method retrieveProduit of ProduitService : produit trouvé !");
                    return produit;
                } )
                .orElseThrow(() -> new ResourceNotFoundException("produit avec id : " + id + "n'existe pas dans la bd"));
    }

    @Transactional
    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        //TODO: check if stock exist  in the database
        //TODO: call stock service and retrieve stock by id
        //TODO: retrive produit by it's id
        //TODO : assign idStock to produit

       /*
       * -  trouver le produit depuis son id
       * - tester si l'id stock entré en parametre est valide
       * - remplir le champ idStock dans le produit avec l'id sotck apres la validation
       */
        log.info("in method retrieveProduit of ProduitService");
        repository.findById(idProduit)
                .map(produit ->{
                    if(checkIfStockExists(idStock)){
                        produit.setIdStock(idStock);
                    } else {
                       throw new ResourceNotFoundException("stock avec l'id :"+idStock+" est introuvable");
                    }
                    return produit;
                })
                .orElseThrow(()->new ResourceNotFoundException("produit avec l'id :"+idProduit+" est introuvable"));

    }
    //TODO:implement this method soon
    public boolean checkIfStockExists(Long idStock){
        return true;
    }
}
