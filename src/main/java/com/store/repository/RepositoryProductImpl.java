package com.store.repository;

import com.store.config.ConnectionTest;
import com.store.model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryProductImpl implements RepositoryProduct {

    @Override
    public List getAll() {
        List productsList = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = ConnectionTest.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Products product = new Products(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock")
                );
                productsList.add(product);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }

        return productsList;
    }

    @Override
    public Optional selectById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (Connection conn = ConnectionTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Products product = new Products(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getBigDecimal("price"),
                            rs.getInt("stock")
                    );
                    return Optional.of(product);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar producto: " + e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public Products save(Products product) {
        String sql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionTest.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, product.getName());
            stmt.setBigDecimal(2, product.getPrice());
            stmt.setInt(3, product.getStock());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        product.setId(generatedKeys.getLong(1));
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
        }

        return product;
    }
    @Override
    public void update(Products products) {
        String sql = "UPDATE products SET name = ?, price = ?, stock = ? WHERE id = ?";

        try (Connection connection = ConnectionTest.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, products.getName());
            preparedStatement.setBigDecimal(2, products.getPrice());
            preparedStatement.setInt(3, products.getStock());
            preparedStatement.setLong(4, products.getId());

            preparedStatement.executeUpdate();   // <- esta línea faltaba

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
