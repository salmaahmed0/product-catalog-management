package com.example.productcatalogmanagement.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class authentication extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user-auth");
        if (user == null && (request.getRequestURI().endsWith("/products") ||
                request.getRequestURI().endsWith("/update") ||
                request.getRequestURI().endsWith("/add-product") ||
                request.getRequestURI().endsWith("/delete"))
           ) {

            request.getRequestDispatcher("login").forward(request, response);
        }else {
            chain.doFilter(request, response);
        }


    }
}
