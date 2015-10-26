package infrastructure;

import infrastructure.location.LocationDAO;
import model.Location;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Paul on 22.10.2015.
 */
@H2LocationQualifier
public class H2LocationDAO  {

    private static Connection connection;


    public H2LocationDAO() {
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


}
