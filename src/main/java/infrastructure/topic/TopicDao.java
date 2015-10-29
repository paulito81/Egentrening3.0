package infrastructure.topic;

import model.Location;
import model.Topic;
import model.User;

import java.util.List;

/**
 * Created by Paul on 25.10.2015.
 */
public interface TopicDao {

    boolean registerTopic(Topic topic);
    Topic getTopicById(int id);
    List<User> getAllRegisteredUserByTopic(Topic topic);

    //TODO one interface topic + location
    boolean createNewLocation(Location location );
    Location getLocationById(int id);

}
