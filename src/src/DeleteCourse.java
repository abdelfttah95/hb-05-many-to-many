package src;

import entity.Course;
import entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class DeleteCourse {

    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            // getting course from db
            int courseId = 10;
            Course tempCourse = (Course) session.get(Course.class, courseId);
            
            // delete the course from db
            System.out.println("Deleting ... " + tempCourse);
            
            session.delete(tempCourse);
            
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
