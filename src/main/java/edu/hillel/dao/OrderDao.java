package edu.hillel.dao;

import edu.hillel.model.Order;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao {
    private final Map<Integer, Order> orders = new HashMap<>();

    public List<Order> getOrders() {
        return orders.values().stream().toList();
    }

    public int getNextId(){
        int id= orders
                .keySet()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);
        return id+1;
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public void deleteOrder(int id) {
        orders.remove(id);
    }

    public void deleteAllOrders() {
        orders.clear();
    }

    public void addOrder(Order order) {
        order.setId(getNextId());
        orders.put(order.getId(), order);
    }
}
