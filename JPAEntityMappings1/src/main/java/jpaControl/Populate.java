/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import entity.Book;
import entity.Customer;
import enums.CustomerType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Populate {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEM1PU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
//        Book b1 = new Book();
//        b1.setAuthor("Oliver Løye");
//        b1.setTitle("Ollitheorange");
//        
//        Book b2 = new Book();
//        b2.setAuthor("Anso Riis");
//        b2.setTitle("Flødebollen");
//        
//        Book b3 = new Book();
//        b3.setAuthor("Luna Lovegood");
//        b3.setTitle("Mutto Mutto");
//        
//        
//        em.persist(b1);
//        em.persist(b2);
//        em.persist(b3);

        Customer c1 = new Customer();
        c1.setFirstName("Ulle");
        c1.setLastName("Bolle");
        c1.setCustomerType(CustomerType.GOLD);
        c1.addHobby("Cycling");
        c1.addPhone("12345678", "test test");
        
        em.persist(c1);
        
        em.getTransaction().commit();
        em.close();
        
        System.out.println(c1.getPhoneDescription("12345678"));
        
    }
}
