package com.dev.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			
            tx.begin();
            
			Member member = em.find(Member.class, "test2");
			
			member.setUserName("testname2");
			
			Member member2 = em.merge(member);
			
			System.out.println(member.hashCode());
			System.out.println(member2.hashCode());
			
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
	}
	
}
