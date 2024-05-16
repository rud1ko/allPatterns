package com.example.pract14.repository;

import com.example.pract14.entity.MarketDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<MarketDB, Long> {}
