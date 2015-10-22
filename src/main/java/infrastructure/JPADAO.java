package infrastructure;

import model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Paul on 22.10.2015.
 */
public class JPADAO implements UserDAO {
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
