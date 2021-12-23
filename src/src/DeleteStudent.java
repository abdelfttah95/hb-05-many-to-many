package src;

import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class DeleteStudent {

    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            // getting the student 
            int theId = 2;
            Student tempStudent = (Student) session.get(Student.class, theId);

            System.out.println("\nloaded student : " + tempStudent);
            System.out.println("courses : " + tempStudent.getCourses());
            
            // deleting the student 
            System.out.println("Deleting .. " + tempStudent);
            
            session.delete(tempStudent);

            session.getTransaction().commit();
            System.out.println("Done.");
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
