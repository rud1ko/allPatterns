package com.example.pract14;

import com.example.pract14.entity.MarketDB;
import com.example.pract14.repository.MarketRepository;
import com.example.pract14.service.MarketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MarketServiceTests {
    @Mock
    private MarketRepository marketRepository;

    @Test
    void getMarkets(){
        MarketDB marketDB1 = new MarketDB(1L, "Gross", "12.Avenue");
        MarketDB marketDB2 = new MarketDB(2L, "Kroos", "20.Avenue");

        Mockito.when(marketRepository.findAll()).thenReturn(List.of(marketDB1, marketDB2));

        MarketService marketService = new MarketService(marketRepository);

        Assertions.assertEquals(2, marketService.getAllMarket().size());
        Assertions.assertEquals("Vasya", marketService.getAllMarket().get(0).getName());
    }
}
