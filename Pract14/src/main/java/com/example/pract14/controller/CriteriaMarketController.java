package com.example.pract14.controller;

import com.example.pract14.entity.Market;
import com.example.pract14.repository.MarketRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class CriteriaMarketController {
    private final EntityManager entityManager;

    @GetMapping("/name/{name}")
    public List<Market> getMarketsByName(@PathVariable String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Market> query = cb.createQuery(Market.class);
        Root<Market> root = query.from(Market.class);
        query.where(cb.equal(root.get("name"), name));
        return entityManager.createQuery(query).getResultList();
    }

    @GetMapping("/address/{address}")
    public List<Market> getMarketsByAddress(@PathVariable String address) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Market> query = cb.createQuery(Market.class);
        Root<Market> root = query.from(Market.class);
        query.where(cb.equal(root.get("address"), address));
        return entityManager.createQuery(query).getResultList();
    }
}
