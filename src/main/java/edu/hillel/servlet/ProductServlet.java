package edu.hillel.servlet;

import com.google.gson.Gson;
import edu.hillel.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter writer = resp.getWriter()){
            final String id = req.getParameter("id");
            if (id==null){
                writer.println(gson.toJson(productService.getProducts()));
            }
            else {
                writer.println(gson.toJson(productService.getProduct(Integer.parseInt(id))));
            }

        }
    }
}
