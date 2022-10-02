package com.microservices.services.interfaces;

import com.microservices.entities.Stock;
import java.util.Set;

public interface IServiceStock {
    Set<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    void deleteStock(Long id);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

    String retrieveStatusStock();
}
