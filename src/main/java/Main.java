import com.store.dataestructure.CustomQueue;
import com.store.model.Products;
import com.store.repository.RepositoryProduct;
import com.store.repository.RepositoryProductImpl;

import com.store.dataestructure.CustomStack;
import com.store.model.AuditAction;
import com.store.model.Campo;
import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        RepositoryProduct repositoryProduct = new RepositoryProductImpl();
        CustomQueue cola = new CustomQueue(repositoryProduct);

        System.out.println(" LIST OF PRODUCTS ");
        List <Products> products = repositoryProduct.getAll();

        for (Products products1: products) {
            System.out.println("id: " + products1.getId() + "Name: " + products1.getName() + "price: " + products1.getPrice() + "stock: " + products1.getStock());
        }
        // buscar por ID probar selectBy(5) para encontrar la targeta grafica
        Optional <Products> foundedProduct = repositoryProduct.selectById(5L);
        if (foundedProduct.isPresent()) {
            Products products1 = foundedProduct.get();
            System.out.println("Founded: " + products1.getName() + "Price: " + products1.getPrice());
        } else {
            System.out.println("didn't find any product with that ID");
        }
        CustomStack pila = new CustomStack();
        pila.push(new AuditAction(1L, Campo.PRICE, new BigDecimal("100")));
        pila.push(new AuditAction(2L, Campo.STOCK, new BigDecimal("5")));
        pila.push(new AuditAction(3L, Campo.PRICE, new BigDecimal("250")));

        System.out.println("peek: " + pila.peek().getProductId());

        System.out.println(pila.pop().getProductId());
        System.out.println(pila.pop().getProductId());
        System.out.println(pila.pop().getProductId());

        System.out.println(pila.pop());
    }

}