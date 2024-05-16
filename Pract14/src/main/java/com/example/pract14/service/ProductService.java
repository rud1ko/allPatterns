package com.example.pract14.service;

import com.example.pract14.entity.MarketDB;
import com.example.pract14.entity.ProductDB;
import com.example.pract14.repository.MarketRepository;
import com.example.pract14.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MarketRepository marketRepository;
    private static final Logger logger = LoggerFactory.getLogger(MarketService.class);

    @Transactional
    public ProductDB saveProductDB(ProductDB productDB){
        logger.info("Выполняется метод saveMarketInDB");
        productDB.setMarket(new MarketDB(1L, "Loli", "SochiCity"));
        return productRepository.save(productDB);
    }

    @Transactional
    public List<ProductDB> findAllProductDB(){
        logger.info("Выполняется метод saveMarketInDB");
        return productRepository.findAll();
    }

    @Transactional
    public ProductDB getProductById(Long id) {
        logger.info("Выполняется метод saveMarketInDB");
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteProduct(Long id) {
        logger.info("Выполняется метод saveMarketInDB");
        productRepository.deleteById(id);
    }
}
