package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductRepository productRepository = ProductRepository.getInstance();
        productRepository.deleteProduct(id);

        System.out.println("item deleted.");
        response.sendRedirect("products");

    }
}
