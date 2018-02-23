/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import Interface.FacadeBook;
import entity.Book;
import entity.EBook;
import entity.PaperBook;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Test {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa2PU");
        
        
        FacadeBook fb = new FacadeBook(emf);
        
        EBook book1 = new EBook();
        PaperBook book2 = new PaperBook();
        
        //From superclass
        book1.setAuhtor("Olivetti");
        book1.setTitle("Mæææh");
        book1.setPrice(175.95);
        
        book2.setAuhtor("Minho");
        book2.setTitle("Run");
        book2.setPrice(249.95);
        
        //from EBook
        book1.setDownloadUrl("www.dksal.dk");
        book1.setSizeMB(4.54);
        
        book2.setInStock(true);
        book2.setShippingWieght(200);
        
        //Create/adds the book with above attributes to the DB.
        fb.addBook(book1);
        fb.addBook(book2);
        
        //Read/finds the book with given isbn no in DB
        System.out.println(fb.findBook(2L));
        System.out.println(fb.findBook(1L));
        
        //Delete book with isbn no. 3 (must be a book with isbn 3 in DB)
        //fb.deleteBook(3L);
        
        //update book isbn no. 2 (must be a book with isbn 2 in DB)
        fb.updatePrice(2L, 1000);
        
        
    }
    
}
