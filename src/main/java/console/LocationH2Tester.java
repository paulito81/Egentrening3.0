package console;

import infrastructure.H2DAOQualifier;
import infrastructure.H2LocationQualifier;
import infrastructure.LocationDAO;
import infrastructure.UserDAO;

import javax.inject.Inject;

/**
 * Created by Paul on 22.10.2015.
 */
public class LocationH2Tester {

    @Inject
    @H2LocationQualifier
    private LocationDAO locationDAO;

    LocationH2Tester(){

    }

    public void execute(){

    }
}
