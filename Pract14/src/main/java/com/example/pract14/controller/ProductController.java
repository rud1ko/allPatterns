package com.example.pract14.controller;

import com.example.pract14.entity.MarketDB;
import com.example.pract14.entity.Product;
import com.example.pract14.entity.ProductDB;
import com.example.pract14.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private List<Product> productList = new ArrayList<>();

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productList.add(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productList;
    }

    @DeleteMapping("/{index}")
    public void deleteProduct(@PathVariable int index) {
        if (index < productList.size()) {
            productList.remove(index);
        }
    }


    // prac15

    @PostMapping("saveProduct")
    public ProductDB saveProductDB(@RequestBody ProductDB productDB){
        return productService.saveProductDB(productDB);
    }

    @GetMapping("getProducts")
    public List<ProductDB> findAllMarketsDB(){
        return productService.findAllProductDB();
    }
}
