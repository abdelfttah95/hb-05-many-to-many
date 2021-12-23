package src;

import entity.Course;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class AddCourses {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            // getting the student 
            int theId = 2;
            Student tempStudent = (Student) session.get(Student.class, theId);
            
            System.out.println("\nloaded student : " + tempStudent);
            System.out.println("courses : " + tempStudent.getCourses());
            
            // create courses  
            Course tempCourse1 = new Course("Security");
            Course tempCourse2 = new Course("Java"); 
            
            // add courses to the student 
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            
            // save courses 
            System.out.println("\nsaving courses .. ");
            session.save(tempCourse1);
            session.save(tempCourse2); 
            
            session.getTransaction().commit();
            System.out.println("Done.");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
}

