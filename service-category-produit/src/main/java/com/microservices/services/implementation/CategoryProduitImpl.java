package com.microservices.services.implementation;

import com.microservices.entities.CategoryProduit;
import com.microservices.exceptions.ResourceNotFoundException;
import com.microservices.repositories.ICategoryProduitRepository;
import com.microservices.services.interfaces.ICategoryProduitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryProduitImpl implements ICategoryProduitService {
    private final ICategoryProduitRepository repository;
    @Override
    public Set<CategoryProduit> retrieveAllCategorieProduits() {
        log.info("In method retrieveAllCategorieProduits");
        return repository
                .findAll()
                .stream()
                .peek(categoryProduit -> log.info(" categoryProduit : " + categoryProduit))
                .collect(Collectors.toSet());
    }

    @Override
    public CategoryProduit addCategorieProduit(CategoryProduit cp) {
        long start = System.currentTimeMillis();
        log.info("In method addCategorieProduit of serviceCategoryProduit");
        CategoryProduit categoryProduit = repository.save(cp);
        log.info("out of method addCategorieProduit in  serviceCategoryProduit");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return categoryProduit;
    }

    @Override
    public void deleteCategorieProduit(Long id) {
        long start = System.currentTimeMillis();
        log.info("In method deleteCategorieProduit of serviceCategoryProduit");
        // get the category by id  and check if it exists in the database
        repository
                .findById(id)
                .map(categoryProduit -> {
                    // if no problems getting the stock by id then we safely delete it
                    repository.delete(categoryProduit);
                    log.info("category {} deleted successfully",categoryProduit.getId());
                    //TODO: break the affectation produit-CategoryProduit
                    return categoryProduit;
                }) // fire an exception if no stock found with the provided id
                .orElseThrow(()->new ResourceNotFoundException("categoty with  id: "+id+" cannot be found"));
        log.info("Out of  method deleteCategorieProduit of serviceCategoryProduit");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
    }

    @Override
    public CategoryProduit updateCategorieProduit(CategoryProduit cp) {
        long start = System.currentTimeMillis();
        log.info("In method updateCategorieProduit");
        //check if category object contains id otherwise repository.save will create a new stock
        if(cp.getId()==null){
            log.error("In method updateCategorieProduit : category object must container id field in order to update it successfully");
            throw new IllegalArgumentException("category object must container id field in order to update it successfully ");
        }
        //if every thing is fine then we perform our update
        CategoryProduit updatedCategory = repository.save(cp);
        //calculate method execution time
        log.info("out of method updateCategorieProduit");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return updatedCategory;
    }

    @Override
    public CategoryProduit retrieveCategorieProduit(Long id) {
        long start = System.currentTimeMillis();
        log.info("in method retrieveCategorieProduit of CaterogyProduitService");
        return repository.findById(id)
                .map(categoryProduit ->{
                    log.info("in method categoryProduit of CaterogyProduitService : produit CaterogyProduit ! : {}",categoryProduit);
                    log.info("out of method updateCategorieProduit");
                    long elapsedTime = System.currentTimeMillis() - start;
                    log.info("Method execution time: " + elapsedTime + " milliseconds.");
                    return categoryProduit;
                } )
                .orElseThrow(() -> new ResourceNotFoundException("produit avec id : " + id + "n'existe pas dans la bd"));
    }
}
