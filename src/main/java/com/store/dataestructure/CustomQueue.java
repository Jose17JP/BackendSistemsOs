package com.store.dataestructure;

import com.store.model.Products;
import com.store.model.Order;
import com.store.repository.RepositoryProduct;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Optional;
public class CustomQueue {
    private Queue<Order> cola = new LinkedList<>();
    private RepositoryProduct repositoryProduct;
  // si usaramos el tipo de dato como String es porque add nuevos produtcos pero
    // como ya tenemos una clase Order lo usamos y encapsulamos
    public CustomQueue(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }
    public void enqueueOrder(Order order) {
        cola.add(order);
    }
    public void processNext() {
        if (cola.isEmpty()) {
            System.out.println("No hay pedidos pendientes");
            return;
        }
        Order order = cola.poll(); // out fisrt product and delete itself with poll

       Optional<Products> result = repositoryProduct.selectById((long)order.getProductId());

      if (result.isEmpty()) {
          System.out.println("This product not exist");
          return;
      }
      Products products = result.get();

      if (products.getStock() >= order.getQuantity()) {
          products.setStock(products.getStock() - order.getQuantity());
          repositoryProduct.update(products);
          System.out.println("pedigree: " + order.getId() + " attended");
      } else {
          System.out.println("insufficient stock to pedigree " + order.getId());
      }
    }
}
