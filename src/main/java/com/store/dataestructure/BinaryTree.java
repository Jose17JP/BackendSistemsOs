package com.store.dataestructure;

import com.store.model.Products;

public class BinaryTree {
    private Nodo raiz;
    public BinaryTree() {
        this.raiz = null;
    }
    public void insert(Products products) { // lo llamo desde afuera
        raiz = insert(raiz, products);
    }
    // privado baja por el arbol hasta encontrar un hueco null y lo pone en el nuevo Nodo
    private Nodo insert(Nodo actual, Products products) {
        if (actual == null) {
            return new Nodo(products);
        }
        if (products.getPrice().compareTo(actual.getProducts().getPrice()) < 0) {
            actual.setLeft(insert(actual.getLeft(), products));
        } else {
            actual.setRight(insert(actual.getRight(), products));
        }
        return actual;
    }
}
