package com.egorbarinov.lesson03.repository;

import com.egorbarinov.lesson03.domain.Product;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class Crud {

    private static ProductRepoImpl productRepo;


    public static void main(String[] args) {
        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();
        productRepo = new ProductRepoImpl();
        System.out.println(productRepo.getRepo().values());

        for (Long i = 1L; i < productRepo.getRepo().size() ; i++) {
            createEntity(em, productRepo.getById(i));
            saveEntity(em, productRepo.getById(i));
        }
    }

    private static void createEntity(EntityManager em, Product entity){

        System.out.println("Creating entity");
        //open transaction
        em.getTransaction().begin();
        //put person into persist area of Hibernate
        em.persist(entity);
        //commit/close transaction
        em.getTransaction().commit();

        System.out.println("Creating finished");

    }

    private static Product readEntity(EntityManager em, long id){
        System.out.println("Start reading");

        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.getTransaction().commit();

        System.out.println("Reading completed->" + product);
        return product;
    }

    private static void saveEntity(EntityManager em, Product entity){
        System.out.println("Start saving");

        em.getTransaction().begin();
        Product savedEntity = em.merge(entity);
        em.getTransaction().commit();

        System.out.println("Saving completed->" + savedEntity);
    }
}
