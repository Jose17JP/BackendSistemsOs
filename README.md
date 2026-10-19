[SistemGestionProducts.md](https://github.com/user-attachments/files/33646058/SistemGestionProducts.md)
#  BackEnd Store OS - E-Commerce & Logistics Engine

A Java backend project for managing inventory, orders and logistics.

This project demonstrates a modular backend architecture in Java, integrating persistence in **PostgreSQL via JDBC**, and custom **Computer Science Data Structures & Algorithms** implemented to handle in-memory operations.

##  Tech Stack & Prerequisites

* **Language:** Java 17
* **Build Tool:** Apache Maven
* **Database:** PostgreSQL (`tienda_db`)
* **Driver:** PostgreSQL JDBC Driver (`org.postgresql:postgresql`)
* **Version Control:** Git & GitHub

## Architecture & Layering

The application organizes components across the following packages:

```
com.store
 ├── config          --> Database connection management JDBC (tienda_db)
 ├── model           --> Core domain entities (Products, Order, AuditAction, Arista, Campo)
 ├── repository      --> Data Access Layer (Interfaces & PostgreSQL JDBC implementations)
 ├── dataestructure  --> Custom Data Structures & Algorithms (Trees, Graphs, Queues, Stacks)
 ├── service         --> Business Logic Layer integrating repositories and data structures
 └── controller      --> Application Controller Layer (ProductController)
```

##  Custom Data Structures & Algorithms Applied

1. **Binary Search Tree (BST) (`dataestructure.BinaryTree`):**
   * **Use Case:** Node insertion for indexing and hierarchical organization of elements.
2. **FIFO Queue (`dataestructure.CustomQueue`):**
   * **Use Case:** Custom queue structure designed for order queueing and FIFO processing.
3. **LIFO Stack (`dataestructure.CustomStack` / `Stack`):**
   * **Use Case:** Stack structures implemented for action history and auditing operations.
4. **Weighted Graph (`dataestructure.Grapho`):**
   * **Use Case:** Graph representation of logistics networks using vertices and edges (`Arista`).

##  Engineering Standards & Best Practices

* **Financial Precision:** All monetary amounts use `java.math.BigDecimal` to prevent floating-point representation errors.
* **Null Safety:** Methods returning potential empty values utilize `java.util.Optional<T>`.
* **SQL Injection Prevention:** All SQL queries use `PreparedStatement` with parametrized values.
* **Resource Management:** Automatic resource cleanup handled via `try-with-resources`.

## ⚙️ Setup & Installation

### 1. Database Configuration

Create a PostgreSQL database named `tienda_db` and run the initial table setup:

```sql
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    stock INT NOT NULL
);
```

Ensure your credentials in `com.store.config.ConnectionTest` match your local PostgreSQL instance:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/tienda_db";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

### 2. Build the Project

Clone the repository and build the project using Maven:

```bash
git clone https://github.com/JoseAndresPoloOrozco/store-backend-os.git
cd store-backend-os
mvn clean compile
```

### 3. Run the Application

Execute the main entry point:

```bash
mvn exec:java -Dexec.mainClass="Main"
```
*(Or execute `Main.java` directly from your IDE).*

##  Roadmap & Future Enhancements

- [ ] Integrate external currency API consumption for real-time price conversion.
- [ ] Implement tree traversal and price range filtering in `BinaryTree`.
- [ ] Connect order processing queue (`CustomQueue`) to `Main` execution flow.
- [ ] Implement Dijkstra's algorithm inside `Grapho` for optimal route calculation.
- [ ] Develop `InventoryAuditService` to handle Undo/Redo operations with `CustomStack`.
- [ ] Refactor package name from `dataestructure` to `datastructure`.

##  WHO made this: 

Developed by **Jose** as a backend portfolio project demonstrating Java core standards, database persistence, and foundational data structures.
