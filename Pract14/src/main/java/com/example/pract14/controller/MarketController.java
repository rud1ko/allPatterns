package com.example.pract14.controller;

import com.example.pract14.dtos.MarketDTO;
import com.example.pract14.dtos.ProductDTO;
import com.example.pract14.entity.Market;
import com.example.pract14.entity.MarketDB;
import com.example.pract14.entity.ProductDB;
import com.example.pract14.service.MarketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/markets")
@AllArgsConstructor
public class MarketController {
    private final MarketService marketService;

    private List<Market> marketList = new ArrayList<>();

    @PostMapping
    public void createMarket(@RequestBody Market market) {
        marketList.add(market);
    }

    @GetMapping
    public List<Market> getAllMarkets() {
        return marketList;
    }

    @DeleteMapping("/{index}")
    public void deleteMarket(@PathVariable int index) {
        marketList.remove(index);
    }

    // prac15

    @PostMapping("saveMarket")
    public MarketDB saveMarketDB(@RequestBody MarketDB marketDB){
        return marketService.saveMarketInDB(marketDB);
    }

    @GetMapping("getMarkets")
    public List<MarketDB> findAllMarketsDB(){
        return marketService.findAllMarketDB();
    }

    //pract16

    @GetMapping("/lazy")
    public List<MarketDTO> getAllMarketsLazy() {
        List<MarketDB> markets = marketService.findAllMarketDB();
        List<MarketDTO> marketDTOs = new ArrayList<>();

        for (MarketDB market : markets) {
            MarketDTO marketDTO = new MarketDTO();
            marketDTO.setId(market.getId());
            marketDTO.setName(market.getName());
            marketDTO.setProducts(new ArrayList<>()); // Необходимо установить пустой список, чтобы избежать LazyInitializationException

            marketDTOs.add(marketDTO);
        }

        return marketDTOs;
    }

    @GetMapping("lazy/{id}/products")
    public List<ProductDTO> getProductsByMarketId(@PathVariable Long id) {
        List<ProductDB> products = marketService.getProductsByMarketId(id);
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (ProductDB product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());

            productDTOs.add(productDTO);
        }

        return productDTOs;
    }
}
