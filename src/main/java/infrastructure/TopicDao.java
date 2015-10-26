package infrastructure;

import model.Topic;
import model.User;

/**
 * Created by Paul on 25.10.2015.
 */
public interface TopicDao {

    boolean registerTopic(Topic topic);
    Topic getTopicById(int id);
    boolean getAllRegisteredUserByTopic(User user, Topic topic);

    // TODO include topic and location


}
