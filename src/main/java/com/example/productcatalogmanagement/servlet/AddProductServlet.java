package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.entity.Products;
import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/add-product.jsp").include(request, response);

        ProductRepository productRepository = (ProductRepository) getServletContext().getAttribute("productRepo");

        String itemName = request.getParameter("item-name");
        double itemPrice = Double.parseDouble(request.getParameter("item-price"));

        Products item = new Products(itemName, itemPrice);
        productRepository.addProduct(item);
        System.out.println("New item added.");
        response.sendRedirect("products");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
