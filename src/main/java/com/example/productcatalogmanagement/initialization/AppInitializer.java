package com.example.productcatalogmanagement.initialization;

import com.example.productcatalogmanagement.repo.ProductRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppInitializer implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ProductRepository productRepo = ProductRepository.getInstance();
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("productRepo", productRepo);
    }

}
