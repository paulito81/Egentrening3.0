package console.JPA;

import infrastructure.location.JPATopicQualifier;
import infrastructure.topic.TopicDao;
import model.Location;
import model.Topic;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Paul on 22.10.2015.
 */
public class TopicJPATester {

    @Inject
    @JPATopicQualifier
    private TopicDao topicDao;


    public TopicJPATester()throws ClassNotFoundException, SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
        EntityManager entityManager = factory.createEntityManager();
    }

    public void execute(){
        System.out.println("-----JPA-TOPIC PRINTOUT:-----------------------------------------------");
        Topic topic = new Topic(1, "IOS");
        Topic topic2 = new Topic(2, "Enterprenørskap");
        Topic topic3 = new Topic(3, "Enterpriseprogrammering");
        Topic topic4 = new Topic(4, "Hovedprosjekt");

        registerTopic(topic);
        registerTopic(topic2);
        registerTopic(topic3);
        registerTopic(topic4);

        getAllRegisteredUserByTopic();
        getTopicById(3);

        Location location = new Location(1, 15, "Vaterland");

        createNewLocation(location);
        getLocationById(1);

    }

    public boolean registerTopic(Topic topic){
        if(topic !=null) {
             topicDao.registerTopic(topic);
             return true;
        }
        else
            return false;
    }

    public boolean getTopicById(int id){
        if(id !=0){
            topicDao.getTopicById(id);
            return true;
        }else
            return false;
    }

    public List<Topic> getAllRegisteredUserByTopic(){
        return topicDao.getAllRegisteredUserByTopic();
    }

    public boolean createNewLocation(Location location ){
        if(location!=null){
            topicDao.createNewLocation(location);
            return true;
        }else
            return false;
    }

    public boolean getLocationById(int id){
        if(id !=0){
            getLocationById(id);
            return true;
        }
        else
            return false;

    }
}
