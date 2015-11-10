package com.dev.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TestCase {

    private EntityManagerFactory emf;

    @Before
    public void init() throws Exception {
        System.out.println("EntityManagerFactory Creating...");
        this.emf = Persistence.createEntityManagerFactory("jpa-test");
    }

    @Test
    public void insertUserTest() throws Exception {
        control(this.emf, new Controller(){
            void control(EntityManager em){

            }
        });
    }

    @After
    public void destroy() throws Exception {
        this.emf.close();
        System.out.println("EntityManagerFactory Close...");
    }

    interface Controller {
        void control(EntityManager em);
    }

    private void control(EntityManagerFactory emf, Controller controller) throws Exception {

        EntityManager em = null;
        EntityTransaction tx = null;

        try{

            System.out.println("EntityManager Creating...");
            em = emf.createEntityManager();
            tx = em.getTransaction();

            System.out.println("Transaction Begin...");
            tx.begin();

            controller.control(em);

            tx.commit();
            System.out.println("Transaction Commit...");

        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
                System.out.println("Transaction Rollback...");
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
                System.out.println("EntityManager Close...");
            }
        }
    }

}
