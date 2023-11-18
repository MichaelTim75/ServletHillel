package edu.hillel.service;

import edu.hillel.dao.OrderDao;
import edu.hillel.dao.ProductDao;
import edu.hillel.model.Order;
import edu.hillel.model.OrderResponse;
import edu.hillel.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderDao orderDao = new OrderDao();
    private final ProductDao productDao = new ProductDao();

    public List<OrderResponse> getOrders(){
        return orderDao.getOrders()
                .stream().map(c->{
                    List<Product> products = Arrays.stream(c.getProductIds())
                            .mapToObj(productDao::getProduct)
                            .toList();
                    return new OrderResponse(c,products);
                })
                .toList();
    }

    public OrderResponse getOrder(int id){
        Order order = orderDao.getOrder(id);
        List<Product> products = Arrays.stream(order.getProductIds())
                .mapToObj(productDao::getProduct)
                .toList();
        return new OrderResponse(order,products);
    }

    public void addOrder(Order order){
        orderDao.addOrder(order);
    }

    public void deleteOrder(int id){
        orderDao.deleteOrder(id);
    }

}
