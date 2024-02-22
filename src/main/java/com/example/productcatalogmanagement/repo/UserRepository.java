package com.example.productcatalogmanagement.repo;

import com.example.productcatalogmanagement.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager ;
    private static volatile UserRepository instance;

    private UserRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static UserRepository getInstance(){
        if (instance == null){
            synchronized (UserRepository.class){
                if (instance == null) {
                    return new UserRepository();
                }
            }
        }
        return instance;
    }

    public boolean findUser(String userName, String password){
        TypedQuery<Users> query = entityManager.createQuery("SELECT s FROM Users s WHERE s.userName=:userName AND s.password=:password", Users.class);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        try{
            Users user = query.getSingleResult();
            if (user != null)
                return true;
            else return false;
        }catch (Exception ex){
            return false;
        }
    }

}
