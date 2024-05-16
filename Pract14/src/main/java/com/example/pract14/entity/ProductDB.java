package com.example.pract14.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductDB {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;
    private String name;
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    private MarketDB market;
}
