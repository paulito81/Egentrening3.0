package infrastructure;

import model.Location;

/**
 * Created by Paul on 22.10.2015.
 */

@JPALocationQualifier
public class JPALocationDAO implements LocationDAO {

    @Override
    public boolean createNewLocation(Location location) {
        return false;
    }

    @Override
    public Location getLocationById(int id) {
        return null;
    }
}
