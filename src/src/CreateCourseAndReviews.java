package src;

import entity.Course;
import entity.Instructor;
import entity.Review;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author abdel
 */
public class CreateCourseAndReviews {
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();
            
            // create a course 
            Course tempCourse = new  Course("Machine Learning");
            
            // add Reviews
            tempCourse.addReview(new Review("Greate Course .. Loved it."));
            tempCourse.addReview(new Review("Loved it."));
            tempCourse.addReview(new Review("pls continue"));
            
            // saving the course 
            System.out.println("Saving the course ");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            
            session.save(tempCourse);
            
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
