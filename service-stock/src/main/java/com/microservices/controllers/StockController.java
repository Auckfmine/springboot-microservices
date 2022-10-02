package com.microservices.controllers;

import com.microservices.dto.StockDto;
import com.microservices.services.interfaces.IServiceStock;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/stock")
public class StockController {
    private final IServiceStock serviceStock;
    @GetMapping("")
    @ResponseBody
    public String TestController(){
        return "stock-service is working fine !!! ";
    }


    @GetMapping("/retrieve-all-stocks")
    @ResponseBody
    public Set<StockDto> getStocks() {
        Set<StockDto> stocks = new HashSet<>();
          serviceStock
                  .retrieveAllStocks()
                  .forEach(stock -> stocks.add(StockDto.toDto(stock)));
        return stocks;
    }

    @GetMapping("/retrieve-stock/{stock-id}")
    @ResponseBody
    public StockDto retrieveStock(@PathVariable("stock-id") Long stockId) {
        return StockDto.toDto(serviceStock.retrieveStock(stockId));
    }


    @PostMapping("/add-stock")
    @ResponseBody
    public StockDto addStock(@RequestBody StockDto s) {
        return StockDto.toDto(serviceStock.addStock(StockDto.toEntity(s)));
    }


    @DeleteMapping("/remove-stock/{stock-id}")
    @ResponseBody
    public void removeStock(@PathVariable("stock-id") Long stockId) {
        serviceStock.deleteStock(stockId);
    }

    @PutMapping("/modify-stock")
    @ResponseBody
    public StockDto modifyStock(@RequestBody StockDto stockDto) {
        return StockDto.toDto(serviceStock.updateStock(StockDto.toEntity(stockDto)));
    }

    /*
     * Spring Scheduler : Comparer QteMin tolérée (à ne pa dépasser) avec
     * Quantité du stock et afficher sur console la liste des produits inférieur
     * au stock La fct schédulé doit obligatoirement etre sans paramètres et
     * sans retour (void)
     */
    // http://localhost:8089/SpringMVC/stock/retrieveStatusStock
    // @Scheduled(fixedRate = 60000)
    // @Scheduled(fixedDelay = 60000)
    //@Scheduled(cron = "*/60 * * * * *")
    @GetMapping("/retrieveStatusStock")
	@ResponseBody
	public String retrieveStatusStock() {
        return serviceStock.retrieveStatusStock();
    }
}
