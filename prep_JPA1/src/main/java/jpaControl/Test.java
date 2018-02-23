/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import Entity.Customer;
import Entity.ItemType;
import Entity.OrderLine;
import Entity.Orderr;
import Interface.FacadeCustomer;
import Interface.FacadeItemType;
import Interface.FacadeOrder;
import Interface.FacadeOrderLine;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Test {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "prepJPA1PU" );
        
        FacadeCustomer fc = new FacadeCustomer( emf );
        FacadeOrder fo = new FacadeOrder(emf);
        FacadeItemType fit = new FacadeItemType(emf);
        FacadeOrderLine fol = new FacadeOrderLine(emf);
        
        Customer c1 = new Customer("Allan", "allan@allan.com");
        Orderr order1 = new Orderr(c1);
        ItemType it1 = new ItemType("Computer", "MacBook Pro", 10000);
        OrderLine ol1 = new OrderLine(it1, 2, order1);
        
        order1.addOrderLine(ol1);
        c1.addOrderr(order1);
        
        Customer c2 = new Customer("Luna", "ll@ll.dk");
        Orderr order2 = new Orderr(c2);
        ItemType it2 = new ItemType("Hagesmæk", "Savleklud", 150);
        OrderLine ol2 = new OrderLine(it2, 4, order2);
        
        order2.addOrderLine(ol2);
        c1.addOrderr(order2);
        
        
        
        
        
        //Opretter en customer, som tilknytter en order
        fc.addCustomer(c1);
        fc.addCustomer(c2);
        
        
//        fc.getAllCustomers().toString();
        
        
        System.out.println("");
        
        System.out.println(fc.findCustomer(1l).toString());
        System.out.println(fc.findCustomer(2l).toString());
        
        System.out.println("");
        
        System.out.println("Order ID: " + fo.findOrder(1l).getId());
        System.out.println("Customer name of order: " + fo.findOrder(1l).getCustomer().getName());
        System.out.println("Item name: " + fo.findOrder(1l).getOrderLines().get(0).getItemType().getName());
        System.out.println("Item description: " + fo.findOrder(1l).getOrderLines().get(0).getItemType().getDescription());
        System.out.println("Item price: " + fo.findOrder(1l).getOrderLines().get(0).getItemType().getPrice() + " kr.");
        System.out.println("Quantity: " + fo.findOrder(1l).getOrderLines().get(0).getQuantity());
        System.out.println("Total order price: " + fo.findOrder(1l).getTotalPrice(0));
        
        System.out.println("");
        
        System.out.println("Order ID: " + fo.findOrder(2l).getId());
        System.out.println("Customer name of order: " + fo.findOrder(2l).getCustomer().getName());
        System.out.println("Item name: " + fo.findOrder(2l).getOrderLines().get(0).getItemType().getName());
        System.out.println("Item description: " + fo.findOrder(2l).getOrderLines().get(0).getItemType().getDescription());
        System.out.println("Item price: " + fo.findOrder(2l).getOrderLines().get(0).getItemType().getPrice() + " kr.");
        System.out.println("Quantity: " + fo.findOrder(2l).getOrderLines().get(0).getQuantity());
        System.out.println("Total order price: " + fo.findOrder(2l).getTotalPrice(0));
        
        
    }
    
}
