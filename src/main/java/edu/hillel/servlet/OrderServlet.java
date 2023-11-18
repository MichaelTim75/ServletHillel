package edu.hillel.servlet;

import com.google.gson.Gson;
import edu.hillel.model.Order;
import edu.hillel.service.OrderService;
import edu.hillel.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private final OrderService orderService = new OrderService();

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            final String id = req.getParameter("id");
            if (id == null) {
                writer.println(gson.toJson(orderService.getOrders()));
            } else {
                writer.println(gson.toJson(orderService.getOrder(Integer.parseInt(id))));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = gson.fromJson(req.getReader(), Order.class);
        orderService.addOrder(order);
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("Order id=" + gson.toJson(order.getId()) + " has been added");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        orderService.deleteOrder(Integer.parseInt(id));
    }
}
