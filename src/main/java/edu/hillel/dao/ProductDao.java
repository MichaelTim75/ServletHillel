package edu.hillel.dao;

import edu.hillel.model.Product;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {
    private final HashMap<Integer, Product> products = new HashMap<>(Map.of(
            1, new Product(1, "Bread", BigDecimal.valueOf(1.5)),
            2, new Product(2, "Milk", BigDecimal.valueOf(2.2)),
            3, new Product(3, "Sugar", BigDecimal.valueOf(1.0)),
            4, new Product(4, "Salt", BigDecimal.valueOf(0.3)),
            5, new Product(5, "Butter", BigDecimal.valueOf(2.8)),
            6, new Product(6, "Flavour", BigDecimal.valueOf(0.5))
    ));

    public Product getProduct(int id) {
        return products.get(id);
    }

    public List<Product> getProducts(){
        return products.values().stream().toList();
    }
}
