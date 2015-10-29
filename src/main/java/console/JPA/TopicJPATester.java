package console.JPA;

import infrastructure.location.JPATopicQualifier;
import infrastructure.topic.TopicDao;

import javax.inject.Inject;

/**
 * Created by Paul on 22.10.2015.
 */
public class TopicJPATester {

    @Inject
    @JPATopicQualifier
    private TopicDao topicDao;

    TopicJPATester(){

    }

    public void execute(){

    }
}
