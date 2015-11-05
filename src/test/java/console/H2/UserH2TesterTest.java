package console.H2;

import infrastructure.user.UserDAO;
import junit.framework.Assert;
import model.Type;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Created by Paul on 05.11.2015.
 */
public class UserH2TesterTest {

    private UserDAO userDAO;
    private User user = new User();

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAO() {
            @Override
            public User createUser(User user) {
                return user;
            }
            @Override
            public boolean updateUser(User user) {
                return true;
            }

            @Override
            public Optional<User> getUserById(int id) {
                 if( id!=0){
                     return Optional.of(user);
                 }
                else
                     return null;
            }

            @Override
            public List<User> getAllUsers() {
                return userDAO.getAllUsers();
            }

            @Override
            public boolean deleteUser(int id) {
                return id != 0;
            }
        };
    }

    @After
    public void tearDown() throws Exception {
        userDAO = null;
    }

    @Test
    public void testExecute() throws Exception {

    }

    @Test
    public void testCreateUserH2() throws Exception {
        User user = new User(3, "ola@yahoo.no", "passord8", Type.STUDENT);
        userDAO.createUser(user);
        System.out.println("TEST: Created new user : " + user.toString() );
        Assert.assertEquals(userDAO.createUser(user), user);
    }

    @Test
    public void testUpdateUserH2() throws Exception {
        User user = new User(4, "Gun@yahoo.no", "passord2", Type.TEACHER);
        userDAO.createUser(user);
        System.out.println("TEST: Created new user : " + user.toString() );
        Assert.assertEquals(userDAO.createUser(user), user);

    }

    @Test
    public void testGetUserByIDH2() throws Exception {
        User user = new User(5, "kei@yahoo.no", "passord3", Type.STUDENT);
        userDAO.createUser(user);
        System.out.println("TEST: Created new user : " + user.toString() );
        Assert.assertEquals(userDAO.createUser(user), user);
    }

    @Test
    public void testGetAllUsersH2() throws Exception {
        User user = new User(6, "lars@yahoo.no", "passord4", Type.TEACHER);
        userDAO.createUser(user);
        System.out.println("TEST: Created new user : " + user.toString() );
        Assert.assertEquals(userDAO.createUser(user), user);
    }

    @Test
    public void testDeleteAUserH2() throws Exception {
        User user = new User(4, "Gun@yahoo.no", "passord2", Type.TEACHER);
        boolean isDeleted =  userDAO.deleteUser(user.getId());
        System.out.println("TEST: User 4 har been deleted : " + isDeleted);
        Assert.assertTrue(isDeleted);
    }
}