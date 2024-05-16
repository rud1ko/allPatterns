package com.example.pract14.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "markets")
public class MarketDB {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductDB> products;

    public MarketDB(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public MarketDB() {

    }
}
