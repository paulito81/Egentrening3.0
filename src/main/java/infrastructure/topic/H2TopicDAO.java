package infrastructure.topic;

import infrastructure.location.H2TopicQualifier;
import model.Location;
import model.Topic;
import model.User;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Paul on 22.10.2015.
 */
@H2TopicQualifier
public class H2TopicDAO implements TopicDao{

    private static Connection connection;


    public H2TopicDAO() {
        connectToH2();
    }

    private synchronized void connectToH2() {

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:userDB;INIT=runscript from 'initH2.sql'", "sa", "");


        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @PreDestroy
    public  void closeConnectionToH2() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
