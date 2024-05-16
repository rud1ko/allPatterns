package com.example.pract14.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String price;
    private Long marketId;
}
