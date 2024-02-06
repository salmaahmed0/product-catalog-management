package com.example.productcatalogmanagement.repo;

import com.example.productcatalogmanagement.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private int sequence = 1;
    private static ProductRepository instance ;
    List<Product> products = new ArrayList<>();

    private ProductRepository() {
        products.add(new Product(sequence++, "Product A", 100));
        products.add(new Product(sequence++, "Product B", 150));
        products.add(new Product(sequence++, "Product C", 170));
        products.add(new Product(sequence++, "Product D", 80));
        products.add(new Product(sequence++, "Product E", 120));
        products.add(new Product(sequence++, "Product F", 50));
        products.add(new Product(sequence++, "Product G", 150));
    }
    public static ProductRepository getInstance(){
        if(instance == null) {
            synchronized (ProductRepository.class){
                if (instance == null) {
                    instance = new ProductRepository();
                }
            }
        }
        return instance;
    }

    public List<Product> findProducts() {
        return products;
    }

    public Product findProduct(int id){
        for (Product i : products){
            if (i.getId() == id)
                return i;
        }
        return null;
    }


    public void addProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
    }
    public boolean updateProduct(Product product){
        for(Product i : products){
            if (i.getId() == product.getId()){
                i.setName(product.getName());
                i.setPrice(product.getPrice());
                return true;
            }
        }
        return false;
    }
    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
