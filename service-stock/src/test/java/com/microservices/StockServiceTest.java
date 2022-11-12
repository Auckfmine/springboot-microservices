package com.microservices;

import com.microservices.dto.StockDto;
import com.microservices.services.implementation.ServiceStockImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {
    ServiceStockImpl stockService = mock(ServiceStockImpl.class);

    StockDto stock = StockDto
            .builder()
            .libelleStock("valid")
            .qte(20)
            .qteMin(10)
            .build();

    StockDto stock2 = StockDto
            .builder()
            .libelleStock("valid1")
            .qte(30)
            .qteMin(20)
            .build();


    StockDto stock3 = StockDto
            .builder()
            .libelleStock("valid")
            .qte(40)
            .qteMin(30)
            .build();


    Set<StockDto> list = new HashSet<>() {
        {
            add(stock2);
            add(stock3);
        }
    };



    @Test
    public void testRetreiveAllStocks() {

        when(stockService.retrieveAllStocks()).thenReturn(list);
        assertNotEquals(list.size(), 0);

    }

    @Test
    public void testUpdateStock(){
        when(stockService.updateStock(stock)).thenReturn(stock);
        assertNotEquals(Optional.ofNullable(stock.getQte()),Optional.of(stockService.updateStock(stock)));
        verify(stockService).updateStock(stock);


    }
}
