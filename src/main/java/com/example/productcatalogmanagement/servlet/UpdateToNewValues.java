package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.entity.Products;
import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update-product")
public class UpdateToNewValues extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        int itemID = Integer.parseInt(request.getParameter("item-id"));
        String itemName = request.getParameter("item-name");
        double itemPrice = Double.parseDouble(request.getParameter("item-price"));

        ProductRepository productRepository = (ProductRepository) getServletContext().getAttribute("productRepo");

        Products item = new Products(itemID, itemName, itemPrice);
        boolean updated = productRepository.updateProduct(item);

        if(updated) System.out.println("Item Updated.");
        response.sendRedirect("products");

    }
}
