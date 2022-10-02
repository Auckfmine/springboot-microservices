package com.microservices.repositories;

import com.microservices.entities.CategoryProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryProduitRepository extends JpaRepository<CategoryProduit,Long> {
}
