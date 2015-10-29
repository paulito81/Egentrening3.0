package console.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

/**
 * Created by Paul on 22.10.2015.
 */
public class UserJPATester {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public UserJPATester()throws ClassNotFoundException, SQLException{
        factory = Persistence.createEntityManagerFactory("user");
        entityManager = factory.createEntityManager();
    }

    public void execute() {

    }
}
