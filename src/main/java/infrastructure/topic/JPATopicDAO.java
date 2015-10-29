package infrastructure.topic;

import model.Location;
import model.Topic;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Paul on 22.10.2015.
 */


public class JPATopicDAO implements TopicDao{

    @PersistenceContext(unitName = "user")
    private EntityManager entityManager;


    public JPATopicDAO() throws ClassNotFoundException, SQLException {

    }

    @Override
    public boolean registerTopic(Topic topic) {
        return false;
    }

    @Override
    public Topic getTopicById(int id) {
        return null;
    }

    @Override
    public List<User> getAllRegisteredUserByTopic(Topic topic) {
        return null;
    }

    @Override
    public boolean createNewLocation(Location location) {
        return false;
    }

    @Override
    public Location getLocationById(int id) {
        return null;
    }
}
