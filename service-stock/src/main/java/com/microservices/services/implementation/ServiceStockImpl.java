package com.microservices.services.implementation;

import com.microservices.entities.Stock;
import com.microservices.exceptions.ResourceNotFoundException;
import com.microservices.repositories.IStockRepository;
import com.microservices.services.interfaces.IServiceStock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ServiceStockImpl implements IServiceStock {
    private final IStockRepository repository;


    @Override
    public Set<Stock> retrieveAllStocks() {
        log.info("In method retrieveAllStocks");
        return repository
                .findAll()
                .stream()
                .peek(stock -> log.info(" Stock : " + stock))
                .collect(Collectors.toSet());
    }

    @Override
    public Stock addStock(Stock s) {
        long start = System.currentTimeMillis();
        log.info("In method retrieveAllStocks of serviceStock");
        Stock stock = repository.save(s);
        log.info("out of method addStock serviceStock");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return stock;
    }

    @Override
    public void deleteStock(Long id) {
        long start = System.currentTimeMillis();
        log.info("In method deleteStock of serviceStock");
        // get the stock by id  and check if it exists in the database
        repository
                .findById(id)
                .map(stock -> {
                    // if no problems getting the stock by id then we safely delete it
                    repository.delete(stock);
                    log.info("stock {} deleted successfully",stock.getId());
                    return stock;
                }) // fire an exception if no stock found with the provided id
                .orElseThrow(()->new ResourceNotFoundException("stock with  id: "+id+" cannot be found"));
        log.info("Out of  method deleteStock of serviceStock");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
    }

    @Override
    public Stock updateStock(Stock s) {
        long start = System.currentTimeMillis();
        log.info("In method updateStock");
        //check if stock object contains id otherwise repository.save will create a new stock
        if(s.getId()==null){
            log.error("In method updateStock : stock object must container id field in order to update it successfully");
            throw new IllegalArgumentException("stock object must container id field in order to update it successfully ");
        }
        //if every thing is fine then we perform our update
        Stock updatedStock = repository.save(s);
        //calculate method execution time
        log.info("out of method updateStock");
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return updatedStock;
    }

    @Override
    public Stock retrieveStock(Long id) {
        long start = System.currentTimeMillis();
        log.info("In method retrieveStock");
        return repository
                .findById(id)
                .map(stock -> {
                    log.info("out of method retrieveStock");
                    long elapsedTime = System.currentTimeMillis() - start;
                    log.info("Method execution time: " + elapsedTime + " milliseconds.");
                    return stock;
                })
                .orElseThrow(()->new ResourceNotFoundException("stock avec l'id : "+id +" est introuvable"));
    }

    @Override
    public String retrieveStatusStock() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String msgDate = sdf.format(now);
        StringBuilder finalMessage = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        List<Stock> stocksEnRouge = repository.retrieveStatusStock();
        for (Stock stock : stocksEnRouge) {
            finalMessage = new StringBuilder(newLine + finalMessage + msgDate + newLine + ": le stock "
                    + stock.getLibelleStock() + " a une quantit?? de " + stock.getQte()
                    + " inf??rieur ?? la quantit?? minimale a ne pas d??passer de " + stock.getQteMin()
                    + newLine);

        }
        log.info(finalMessage.toString());
        return finalMessage.toString();
    }
}
