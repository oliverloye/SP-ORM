/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Oliver
 */
@Entity
@DiscriminatorValue("P")
public class PaperBook extends Book {
    private double shippingWieght;
    private boolean inStock;

    public double getShippingWieght() {
        return shippingWieght;
    }

    public void setShippingWieght(double shippingWieght) {
        this.shippingWieght = shippingWieght;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "PaperBook{" + "shippingWieght=" + shippingWieght + ", inStock=" + inStock + '}';
    }

    
}
