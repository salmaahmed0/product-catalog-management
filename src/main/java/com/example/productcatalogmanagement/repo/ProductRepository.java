package com.example.productcatalogmanagement.repo;

import com.example.productcatalogmanagement.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
public class ProductRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager ;
    private volatile static ProductRepository instance;

    private ProductRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public static ProductRepository getInstance(){
        if (instance == null){
            synchronized (ProductRepository.class){
                if (instance == null) {
                    return new ProductRepository();
                }
            }
        }
        return instance;
    }
    public List<Products> findProducts(){
        return entityManager.createQuery("SELECT s FROM Products s", Products.class).getResultList();
    }

    public Products findProductById(int id){
        return entityManager.find(Products.class, id);
    }

    public  boolean addProduct(Products product){
        try {
            beginTransaction();
            entityManager.persist(product);
            commitTransaction();
            return true;
        }catch (Exception ex){
            System.out.println("Database Error : " + ex.getMessage());
            rollBackTransaction();
            return false;
        }
    }

    public boolean updateProduct(Products product){
        try{
            beginTransaction();
            entityManager.merge(product);
            commitTransaction();
            return true;
        }catch (Exception ex){
            System.out.println("Database Error : " + ex.getMessage());
            rollBackTransaction();
            return false;
        }
    }

    public boolean delete(int id){
        try {
            beginTransaction();
            Products product = entityManager.find(Products.class, id);
            entityManager.remove(product);
            commitTransaction();
            return true;
        }catch (Exception ex){
            System.out.println("Database Error : " + ex.getMessage());
            rollBackTransaction();
            return false;
        }
    }

    private void beginTransaction(){
        entityManager.getTransaction().begin();
    }

    private void commitTransaction(){
        entityManager.getTransaction().commit();
    }

    private void rollBackTransaction(){
        entityManager.getTransaction().rollback();
    }
}
