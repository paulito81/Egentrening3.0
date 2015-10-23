package infrastructure;

import model.Location;

/**
 * Created by Paul on 22.10.2015.
 */
@H2LocationQualifier
public class H2LocationDAO implements LocationDAO {




    @Override
    public boolean createNewLocation(Location location) {
        return false;
    }

    @Override
    public Location getLocationById(int id) {
        return null;
    }
}
