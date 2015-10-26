package infrastructure;

import infrastructure.location.LocationDAO;
import model.Location;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

/**
 * Created by Paul on 22.10.2015.
 */


public class JPALocationDAO {

    private EntityManagerFactory factory;
    private EntityManager entityManager;


    public JPALocationDAO() throws ClassNotFoundException, SQLException {
        factory = Persistence.createEntityManagerFactory("location");
        entityManager = factory.createEntityManager();
    }
    @PreDestroy
    private void close(){
        entityManager.close();
        factory.close();
    }

}
