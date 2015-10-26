package console;

import infrastructure.JPALocationQualifier;
import infrastructure.location.LocationDAO;

import javax.inject.Inject;

/**
 * Created by Paul on 22.10.2015.
 */
public class LocationJPATester {

    @Inject
    @JPALocationQualifier
    private LocationDAO locationDAO;

    LocationJPATester(){

    }

    public void execute(){

    }
}
