package com.store.repository;
import com.store.model.Products; // we import la capa de modelo con la clase products
import java.util.Optional;
import java.util.List;
public interface RepositoryProduct {
    Products save(Products products); // INSERT INTO products (name, price, stock)....
    Optional<Products> selectById(Long id);
    List<Products>getAll(); // obtener toda la lista

    void update(Products products);
    // por aca es donde java se comunica con la bases de datos esta es la capa
}
