/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entity.Book;

/**
 *
 * @author Oliver
 */
public interface FacadeBookInterface {
    
    //Create book
    public void addBook(Book book);
    
    //Read book
    public Book findBook(Long isbn);
    
    //Update book
    public void updatePrice(Long isbn, double price);
    
    //Delete book
    public void deleteBook(Long isbn);
    
}
