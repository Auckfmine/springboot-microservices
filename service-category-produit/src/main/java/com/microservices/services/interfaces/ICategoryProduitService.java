package com.microservices.services.interfaces;

import com.microservices.entities.CategoryProduit;

import java.util.Set;

public interface ICategoryProduitService {
    Set<CategoryProduit> retrieveAllCategorieProduits();

    CategoryProduit addCategorieProduit(CategoryProduit cp);

    void deleteCategorieProduit(Long id);

    CategoryProduit updateCategorieProduit(CategoryProduit cp);

    CategoryProduit retrieveCategorieProduit(Long id);
}
