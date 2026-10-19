package com.store.controller;
import com.store.model.Products;
import com.store.service.ProductsService;
import java.math.BigDecimal;

public class ProductController {
    private final ProductsService productsService;

    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    public String registerNewProduct(String name, BigDecimal price, Integer stock) {
        try {
            Products newProduct = new Products(null, name, price, stock);
            Products safed = productsService.createProducts(newProduct);

            return "successful: product " + safed.getName() + "registered";
        } catch (IllegalArgumentException e) {
            return "Error validation: " + e.getMessage();
        }
    }

}
