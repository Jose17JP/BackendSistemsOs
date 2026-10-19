package com.store.service;
import com.store.model.Products;
import com.store.repository.RepositoryProduct;
import java.math.BigDecimal;


public class ProductsService {
    private final RepositoryProduct repositoryProduct;

    // inyeccion de dependencia por constructor
    public ProductsService(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }

    public Products createProducts(Products products) {
        BigDecimal limitPrice = new BigDecimal("1000");
        // el precio no puede ser nulo ni negativo o cero
        if (products.getPrice() == null || products.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("the price must be higher than zero");
        }
        if (products.getStock() == null || products.getStock() < 0) {
            throw new IllegalArgumentException("Stock can't be negative");
        }
        if (products.getPrice().compareTo(limitPrice) > 0 && products.getStock() < 5) {
            throw new IllegalArgumentException("the Products with highest price than 1.000 must have a initial  stock to at least 5 units");
    }

        return repositoryProduct.save(products); // si pasa todo lo guardamos en la base de datos
    }

}
