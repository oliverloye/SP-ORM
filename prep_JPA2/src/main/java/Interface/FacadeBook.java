/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Oliver
 */
public class FacadeBook implements FacadeBookInterface {

    private EntityManagerFactory emf;

    public FacadeBook(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void addBook(Book book) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @Override
    public Book findBook(Long isbn) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Book book = em.find(Book.class, isbn);
            em.getTransaction().commit();
            return book;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteBook(Long isbn) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Book book = em.find(Book.class, isbn);
            em.remove(book);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updatePrice(Long isbn, double price) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.find(Book.class, isbn).setPrice(price);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
