import javax.persistence.*;

import quiz.Quiz;
import quiz.Question;
import quiz.Response;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Open a database connection
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/p2.odb");
        EntityManager em = emf.createEntityManager();

        /*
        em.getTransaction().begin();
        for (int i = 0; i < 1000; i++) {
            Point p = new Point(i, i);
            em.persist(p);
        }
        em.getTransaction().commit();


        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());
        */

        Response r1 = new Response("Flat", false);
        Response r2 = new Response("Circular", false);
        Response r3 = new Response("Spherical", true);
        Response r4 = new Response("Cubical", false);
        List<Response> answers = Arrays.asList(r1, r2, r3, r4);
        Question question = new Question("Physics", 1, "What shape is the Earth?", answers);
        Quiz quiz = new Quiz(Arrays.asList(question));

        em.getTransaction().begin();
        em.persist(quiz);
        em.getTransaction().commit();

        TypedQuery<Quiz> query = em.createQuery("SELECT quiz FROM Quiz quiz", Quiz.class);
        List<Quiz> results = query.getResultList();
        System.out.println(results.get(0));

        

        // Close the database connection:
        em.close();
        emf.close();
    }
}