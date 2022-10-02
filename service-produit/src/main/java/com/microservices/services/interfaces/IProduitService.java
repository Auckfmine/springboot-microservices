package com.microservices.services.interfaces;

import com.microservices.entities.Produit;
import java.util.Set;

public interface IProduitService {
    Set<Produit> retrieveAllProduits();

    Produit addProduit(Produit p);

    void deleteProduit(Long id);

    Produit updateProduit(Produit p);

    Produit retrieveProduit(Long id);

    void assignProduitToStock(Long idProduit, Long idStock);
}
