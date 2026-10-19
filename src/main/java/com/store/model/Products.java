package com.store.model;

import java.math.BigDecimal;

public class Products {
    private Long id; // tipo de dato para numeros enteros grandes largos
    private String name;
    private BigDecimal price; // es una clase para repre. numeros decimales con presicion exacta
    private Integer stock;

    public Products() {
    }

    public Products(Long id, String name, BigDecimal price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;

    }
    // un constructor sin id porque el id lo crea automaticamente postgreSQL
    public Products(String name, BigDecimal price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

