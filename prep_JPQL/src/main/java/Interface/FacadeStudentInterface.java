/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import entity.Student;
import java.util.List;

/**
 *
 * @author Oliver
 */
public interface FacadeStudentInterface {
    
    public List<Student> getAllStudents();
    public Student getStudentByFirstName(String firstName); //Denne funktion bør nok returnere List<Student>, såfremt der nu er flere med firstname: Anders
    public List<Student> getStudentsByLastName(String lastName);
    public void addStudent(Student student);
    public void assignStudentToSemester(Long studentID, Long semesterID);
    
}
