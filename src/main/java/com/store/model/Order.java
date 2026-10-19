package com.store.model;

public class Order {
    private int id;
    private Long productId; // que producto se pide
    private int quantity; // cuantas cantidades

    public Order(int id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public Long getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public String toString() {
        return "id: " + id + " productId:" + productId + " quantity:" + quantity;
    }
}
