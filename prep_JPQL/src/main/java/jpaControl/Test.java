/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import Interface.FacadeStudent;
import entity.Student;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Oliver
 */
public class Test {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "jpqlPU" );
        
        FacadeStudent fs = new FacadeStudent(emf);
        
        
        System.out.println("Find alle students:");
        System.out.println(fs.getAllStudents().toString());
        
        
        System.out.println("");
        
        System.out.println("Find én student med firstname = Anders:");
        System.out.println(fs.getStudentByFirstName("Anders").toString());
        
        System.out.println("");
        
        System.out.println("Opretter en ny student");
        Student student1 = new Student();
        student1.setFirstname("Oliver");
        student1.setLastname("Løye");
//        fs.addStudent(student1);
        System.out.println(fs.getStudentByFirstName(student1.getFirstname()));
        
        System.out.println("");
        
        System.out.println("Finder alle students med lastname = And:");
        System.out.println(fs.getStudentsByLastName("And").toString());
        
        System.out.println("");
        
        System.out.println("Tilføjer et semester til en student");
        fs.assignStudentToSemester(7L,3L);
        
        
        
    }
    
}
