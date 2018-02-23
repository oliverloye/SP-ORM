/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entity.Semester;
import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Oliver
 */
public class FacadeStudent implements FacadeStudentInterface {
    
    private EntityManagerFactory emf;

    public FacadeStudent(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Student.findAll");
        List<Student> allStudents = query.getResultList();
        return allStudents;
    }

    @Override
    public Student getStudentByFirstName(String firstName) {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Student.findByFirstname");
        query.setParameter("firstname", firstName);
        Student result = (Student) query.getSingleResult();
        return result;
    }

    @Override
    public void addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
//        Query query = em.createQuery("INSERT INTO STUDENT (ID, FIRSTNAME, LASTNAME, CURRENTSEMESTER_ID) VALUES (?,?,?,?)");
//        query.setParameter(1, student.getId());
//        query.setParameter(2, student.getFirstname());
//        query.setParameter(3, student.getLastname());
//        query.setParameter(4, student.getCurrentsemesterId());
//        query.executeUpdate();
        
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            
        } finally {
            em.close();
        }
    }

    @Override
    public List<Student> getStudentsByLastName(String lastName) {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Student.findByLastname");
        query.setParameter("lastname", lastName);
        List<Student> allStudents = query.getResultList();
        return allStudents;
    }

    @Override
    public void assignStudentToSemester(Long studentID, Long semesterID) {
        EntityManager em = emf.createEntityManager();
        
        Student student = new Student();
        Query query1 = em.createNamedQuery("Student.findById");
        query1.setParameter("id", studentID);
        student = (Student) query1.getSingleResult();
        
        Semester semester = new Semester();
        Query query2 = em.createNamedQuery("Semester.findById");
        query2.setParameter("id", semesterID);
        semester = (Semester) query2.getSingleResult();
        System.out.println("Inside assignStudentToSemester method: " + semester.toString());
        System.out.println("Student objekt: " + student.getFirstname() + " " + student.getLastname());
        student.setCurrentsemesterId(semester);
        System.out.println("Student current semesterID: " + student.getCurrentsemesterId());
        
//        Query query3 = em.createQuery("UPDATE c SET CURRENTSEMESTER_ID = " + semester.getId() + " WHERE c.ID = " + student.getId());
        Query query3 = em.createQuery("UPDATE STUDENT SET CURRENTSEMESTER_ID = " + semester.getId() + " WHERE ID = " + student.getId());
        query3.executeUpdate();
        
//        Query query4 = em.createQuery("UPDATE STUDENT SET CURRENTSEMESTER_ID = :p WHERE c.ID = :p");
//        query4.setParameter(1, semester.getId());
//        query4.setParameter(2, student.getId());
//        query4.executeUpdate();
        
        
        
    }
    
}
