package com.example.pract14.dtos;


import com.example.pract14.entity.ProductDB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class MarketDTO {
    private Long id;
    private String name;
    private String address;
    private List<ProductDB> products;
}
