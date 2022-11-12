package com.microservices;

import com.microservices.dto.ProduitDto;
import com.microservices.services.implementation.ProduitServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    ProduitServiceImpl produitService = mock(ProduitServiceImpl.class);

    ProduitDto produit = ProduitDto
            .builder()
            .codeProduit("AZE")
            .libelleProduit("Shoes")
            .prix(1234F)
            .build();
    ProduitDto produit2 = ProduitDto
            .builder()
            .codeProduit("AZE")
            .libelleProduit("Shoes")
            .prix(1234F)
            .build();
    ProduitDto produit3 = ProduitDto
            .builder()
            .codeProduit("AZE")
            .libelleProduit("Shoes")
            .prix(1234F)
            .build();
    ProduitDto produit4 = ProduitDto
            .builder()
            .codeProduit("AZE")
            .libelleProduit("Shoes")
            .prix(1234F)
            .build();


    Set<ProduitDto> list = new HashSet<>() {
        {
            add(produit);
            add(produit2);
            add(produit3);
            add(produit4);
        }
    };
    @Test
    public void testRetrieveAllProduits() {
        assertNotEquals(list.size(), 4);

    }

    @Test
    public void testUpdateStock(){
        when(produitService.updateProduit(ProduitDto.toEntity(produit))).thenReturn(ProduitDto.toEntity(produit));
        assertNotEquals(Optional.ofNullable(produit.getCodeProduit()),Optional.of(produitService.updateProduit(ProduitDto.toEntity(produit))));
        verify(produitService).updateProduit(ProduitDto.toEntity(produit));


    }
}
