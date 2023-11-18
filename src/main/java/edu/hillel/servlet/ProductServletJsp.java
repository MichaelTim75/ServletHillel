package edu.hillel.servlet;

import com.google.gson.Gson;
import edu.hillel.model.Product;
import edu.hillel.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/product-jsp")
public class ProductServletJsp extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts();
        req.setAttribute("productList",products);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/productList.jsp");
        dispatcher.forward(req, resp);
    }
}
