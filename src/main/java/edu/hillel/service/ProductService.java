package edu.hillel.service;

import edu.hillel.dao.ProductDao;
import edu.hillel.model.Product;

import java.util.List;

public class ProductService {
    private final ProductDao productDao = new ProductDao();

    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    public Product getProduct(int id){
        return productDao.getProduct(id);
    }

}
