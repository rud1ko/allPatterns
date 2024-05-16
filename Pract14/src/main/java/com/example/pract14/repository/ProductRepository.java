package com.example.pract14.repository;

import com.example.pract14.entity.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDB, Long> { }
