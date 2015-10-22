package infrastructure;

import model.Location;

/**
 * Created by Paul on 22.10.2015.
 */
public interface LocationDAO {

    boolean createNewLocation(Location location );
    Location getLocationById(int id);
}
