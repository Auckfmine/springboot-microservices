package com.microservices.services.interfaces;

import com.microservices.dto.StockDto;
import com.microservices.entities.Stock;
import java.util.Set;

public interface IServiceStock {
    Set<StockDto> retrieveAllStocks();

    StockDto addStock(StockDto s);

    void deleteStock(Long id);

    StockDto updateStock(StockDto u);

    Stock retrieveStock(Long id);

    String retrieveStatusStock();
}
