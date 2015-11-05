package infrastructure.topic;

import model.Location;
import model.Topic;

import java.util.List;

/**
 * Created by Paul on 25.10.2015.
 */
public interface TopicDao {

    Topic registerTopic(Topic topic);
    Topic getTopicById(int id);
    List<Topic> getAllRegisteredUserByTopic();
    Location createNewLocation(Location location );
    Location getLocationById(int id);

}
