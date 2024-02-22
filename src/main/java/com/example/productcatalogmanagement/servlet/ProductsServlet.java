package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.entity.Products;
import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductRepository productRepository = (ProductRepository) getServletContext().getAttribute("productRepo");
        List<Products> products = productRepository.findProducts();

        request.setAttribute("products-list", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);

    }
}
