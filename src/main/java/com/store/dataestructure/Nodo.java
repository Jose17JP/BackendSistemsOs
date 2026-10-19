package com.store.dataestructure;

import com.store.model.Products;

public class Nodo<T>{
    private Products products;
    private Nodo left;
    private Nodo right;

    public Nodo(Products products) {
        this.products = products;
        this.left = null; // null porque el nodo aun no tiene hijo left
        this.right = null; // not right son yet
    }
    public Products getProducts() {
        return products;
    }
    public Nodo getLeft() {
        return left;
    }
    public void setLeft(Nodo<T> left) {
        this.left = left;
    }
    public Nodo getRight() {
        return right;
    }
    public void setRight(Nodo<T> right) {
        this.right = right;
    }

}
