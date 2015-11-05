package console.JPA;

import infrastructure.location.JPATopicQualifier;
import infrastructure.topic.JPATopicDAO;
import model.Location;
import model.Topic;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Paul on 22.10.2015.
 */
public class TopicJPATester {

    @Inject
    @JPATopicQualifier
    private JPATopicDAO jpaTopicDAO;


    public TopicJPATester()throws ClassNotFoundException, SQLException {
        jpaTopicDAO = new JPATopicDAO();
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

            jpaTopicDAO.registerTopic(topic);
             return true;
        }
        else
            return false;
    }

    public boolean getTopicById(int id){
        if(id !=0){
            jpaTopicDAO.getTopicById(id);
            return true;
        }else
            return false;
    }

    public List<Topic> getAllRegisteredUserByTopic()
    {
        return jpaTopicDAO.getAllRegisteredUserByTopic();
    }

    public boolean createNewLocation(Location location ){
        if(location!=null){
            jpaTopicDAO.createNewLocation(location);
            return true;
        }else
            return false;
    }

    public Location getLocationById(int id){
        if(id !=0){
           return jpaTopicDAO.getLocationById(id);
        }
        else
            return null;

    }
}
