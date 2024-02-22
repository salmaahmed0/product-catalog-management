package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.entity.Products;
import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductRepository productRepository = (ProductRepository) getServletContext().getAttribute("productRepo");
        Products product = productRepository.findProductById(id);

        request.setAttribute("id", id);
        request.setAttribute("name", product.getName());
        request.setAttribute("price", product.getPrice());

        request.getRequestDispatcher("/update-product.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
