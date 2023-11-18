package edu.hillel.dao;

import edu.hillel.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;


class OrderDaoTest {

    private final OrderDao orderDao = new OrderDao();

    @Test
    void getOrders() {
        int[] products = { 1, 2 };
        Order order = Order.builder()
                .date(LocalDate.of(2023,1,1))
                .cost(BigDecimal.valueOf(1.5))
                .productIds(products)
                .build();
        orderDao.addOrder(order);

        Assertions.assertEquals(1,orderDao.getOrders().size());
        Assertions.assertEquals(1,orderDao.getOrder(1).getId());
    }

    @Test
    void getNextId() {
        Assertions.assertEquals(1,orderDao.getNextId());
    }

    @Test
    void getOrder() {
        int[] products = { 1, 2 };
        Order order = Order.builder()
                .date(LocalDate.of(2023,1,1))
                .cost(BigDecimal.valueOf(1.5))
                .productIds(products)
                .build();
        orderDao.addOrder(order);

        Assertions.assertEquals(1,orderDao.getOrder(1).getId());
        Assertions.assertEquals(BigDecimal.valueOf(1.5),orderDao.getOrder(1).getCost());
        Assertions.assertEquals(LocalDate.of(2023,1,1),orderDao.getOrder(1).getDate());
    }

    @Test
    void deleteOrder() {
        int[] products = { 1, 2 };
        Order order = Order.builder()
                .date(LocalDate.of(2023,1,1))
                .cost(BigDecimal.valueOf(1.5))
                .productIds(products)
                .build();
        orderDao.addOrder(order);
        orderDao.deleteOrder(1);
        Assertions.assertEquals(0,orderDao.getOrders().size());
    }

    @Test
    void deleteAllOrders() {
        int[] products = { 1, 2 };
        Order order = Order.builder()
                .date(LocalDate.of(2023,1,1))
                .cost(BigDecimal.valueOf(1.5))
                .productIds(products)
                .build();
        orderDao.addOrder(order);
        orderDao.deleteAllOrders();
        Assertions.assertEquals(0,orderDao.getOrders().size());
    }

    @BeforeEach
    void setUp() {
        orderDao.deleteAllOrders();
    }
}