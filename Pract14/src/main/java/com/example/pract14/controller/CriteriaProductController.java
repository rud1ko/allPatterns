package com.example.pract14.controller;

import com.example.pract14.entity.Product;
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
public class CriteriaProductController {
    private final EntityManager entityManager;

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.where(cb.equal(root.get("name"), name));
        return entityManager.createQuery(query).getResultList();
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductsByPrice(@PathVariable String price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.where(cb.equal(root.get("price"), price));
        return entityManager.createQuery(query).getResultList();
    }
}
