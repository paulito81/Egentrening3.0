package infrastructure.topic;

import infrastructure.user.qualifier.JPAUserQualifier;
import model.Location;
import model.Topic;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Paul on 22.10.2015.
 */

@JPAUserQualifier
public class JPATopicDAO implements TopicDao {

    @PersistenceContext(unitName = "user")
    private EntityManager entityManager;
    private EntityManagerFactory factory;


    public JPATopicDAO() throws ClassNotFoundException, SQLException {
        factory = Persistence.createEntityManagerFactory("user");
        entityManager = factory.createEntityManager();
    }

    JPATopicDAO(EntityManager entityManager){
        this.entityManager =entityManager;
    }

    @Override
    public Topic registerTopic(Topic topic) {
        entityManager.persist(topic);
        return topic;
    }

    @PreDestroy
    private void close(){
        entityManager.close();
        factory.close();
    }
    @Override
    public Topic getTopicById(int id) {
        return entityManager.find(Topic.class, id);
    }

    @Override
    public List<Topic> getAllRegisteredUserByTopic() {
        TypedQuery<Topic> query = entityManager.createNamedQuery("Topic.getAllUsers", Topic.class);
        return query.getResultList();
    }

    @Override
    public Location createNewLocation(Location location) {
        entityManager.persist(location);
        return location;
    }

    @Override
    public Location getLocationById(int id) {

        return entityManager.find(Location.class, id);
    }
}
