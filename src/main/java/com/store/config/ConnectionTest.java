package com.store.config;
import java.sql.Connection; // es una interfaz que representa una tuberia abierte entre mi programa y la bases de datos
import java.sql.DriverManager; // es una clase gestora que administra los driver de la bases de datos
                               // si le doy la direccion URL, usuario, clave el lo buscara
import java.sql.SQLException; // importamos una exception escializada en probelmas de bases de datos

public class ConnectionTest {
        private static final String url = "jdbc:postgresql://localhost:5432/tienda_db";
        private static final String user = "postgres";
        private static final String key = System.getenv("DB_PASSWORD");

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, key);
        }
        public static void main(String[] args) {

                try (Connection connection = getConnection()) {
                    System.out.println("successful connection");
                } catch (SQLException exception) {
                    System.out.println("Error to connect: " + exception.getMessage());
                }
        }
}
