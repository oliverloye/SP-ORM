/*
Jeg har valgt at bruge Single Table Inheritance.
Dette har jeg gjort, fordi jeg personligt selv godt kan lide at have alle klasserne i én enkelt tabel. Og med den ekstra 'discriminator'-kolonne("BOOK_TYPE"), som angiver hvilken
subclass der er indsat i DB, synes jeg, at man får et godt overblik. 

@Column(nullable = false) virker tilsynladende ikke med Single Table Inheritance. 
    
 */
package entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 *
 * @author Oliver
 */
@Entity
@Inheritance
@DiscriminatorColumn(name="BOOK_TYPE")
@Table(name="BOOK")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;
    private String title;
    private String auhtor;
    private double price;

    public Book(Long isbn, String title, String auhtor, double price) {
        this.isbn = isbn;
        this.title = title;
        this.auhtor = auhtor;
        this.price = price;
    }

    public Book() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuhtor() {
        return auhtor;
    }

    public void setAuhtor(String auhtor) {
        this.auhtor = auhtor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the isbn fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Book[ id=" + isbn + " ]";
    }
    
}
