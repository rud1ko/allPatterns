package com.example.pract14.service;

import com.example.pract14.entity.MarketDB;
import com.example.pract14.entity.ProductDB;
import com.example.pract14.repository.MarketRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MarketService {
    private final MarketRepository marketRepository;
    private static final Logger logger = LoggerFactory.getLogger(MarketService.class);

    @Transactional
    public MarketDB saveMarketInDB(MarketDB marketDB){
        logger.info("Выполняется метод saveMarketInDB");
        return marketRepository.save(marketDB);
    }

    @Transactional
    public List<MarketDB> findAllMarketDB(){
        logger.info("Выполняется метод saveMarketInDB");
        return marketRepository.findAll();
    }

    @Transactional
    public MarketDB getMarketById(Long id) {
        logger.info("Выполняется метод saveMarketInDB");
        return marketRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteMarket(Long id) {
        logger.info("Выполняется метод saveMarketInDB");
        marketRepository.deleteById(id);
    }

    @Transactional
    public List<ProductDB> getProductsByMarketId(Long marketId) {
        logger.info("Выполняется метод saveMarketInDB");
        MarketDB market = marketRepository.findById(marketId).orElse(null);
        if (market != null) {
            return market.getProducts();
        }
        return Collections.emptyList();
    }

    public List<MarketDB> getAllMarket(){
        return marketRepository.findAll();
    }
}
