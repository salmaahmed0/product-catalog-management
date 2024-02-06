package com.example.productcatalogmanagement.servlet;

import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletContext implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ProductRepository.getInstance();
    }

}
