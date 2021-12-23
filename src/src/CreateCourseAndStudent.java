package src;

import entity.Course;
import entity.Review;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class CreateCourseAndStudent {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            // create a course 
            Course tempCourse = new  Course("Machine Learning");
            
            session.save(tempCourse);
            System.out.println("\nsaving the course ... " + tempCourse);
   
            // create students
            Student tempStudent1 = new Student("abdelfttah", "sameeh", "abdelfttah@email.com");
            Student tempStudent2 = new Student("saif", "mohamed", "saif@email.com");
            
            // add students to course 
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);
            
            // save students
            session.save(tempStudent1);
            session.save(tempStudent2);
            System.out.println("\nsaved students : " + tempCourse.getStudents());
            
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
