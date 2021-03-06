/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Oliver
 */
public class FacadeCustomer implements FacadeCustomerInterface {
    
    private EntityManagerFactory emf;

    public FacadeCustomer(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public void addCustomer(Customer customer) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
        
    }

    @Override
    public Customer findCustomer(Long id) {
        
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

//    @Override
//    public List<Customer> getAllCustomers() {
//        EntityManager em = emf.createEntityManager();
//        Query query1 = em.createQuery("SELECT c FROM CUSTOMER c");
//        List<Customer> customers = query1.getResultList();
//        return customers;
//    }
    
}
