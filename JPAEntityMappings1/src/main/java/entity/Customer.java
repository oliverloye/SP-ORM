/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.CustomerType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Oliver
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    
    @ElementCollection()
    private List<String> hobbies = new ArrayList();
    
    @Enumerated(EnumType.STRING) //Skriver navnet på customertype i DB i stedet for index-tal
    private CustomerType customerType;
    
    @ElementCollection(fetch = FetchType.LAZY) //Phones bliver først hentet når get() method bliver kaldt. Eagerly ville hente alle phones samtidigt med Customer bliver kaldt.
    @MapKeyColumn(name = "PHONE") //Angiver navnet på kolonnen med keys i DB 
    @Column(name = "Description") //Angiver navnet på kolonnen med values i DB.
    private Map<String,String> phones = new HashMap();
    
    
    @OneToMany
    private List<Address> addresses = new ArrayList();

    public Customer(Long id, String firstName, String lastName, CustomerType customerType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerType = customerType;
    }
    
    public Customer() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getHobbies() {
        return String.join(",", hobbies);
    }

    public void addHobby(String s) {
        hobbies.add(s);
    }
    
    public void addPhone(String phoneNo, String description) {
        phones.put(phoneNo, description);
    }

    public String getPhoneDescription(String phoneNo) {
        return phones.get(phoneNo);
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbies=" + hobbies + ", customerType=" + customerType + '}';
    }

    
    
}


/*

2.1
    fields added.

2.2
    Customer now knows the Address class but not the other way around. Nothing changed in the Address class.

2.3
    Bidirectinal means that both classes know each other. Therefore the Address class will generate an object of the Customer class.
    OnetoOne-Bidirectional relationship ask for the owning side (which class/table should hold the foreign keys). I choose Address as the owning side.

2.4
    Bliver oprettet et ekstra tabel som holder Customer ID og Address ID.
    Jeg er lidt usikker på JoinColumn annotationen..
*/