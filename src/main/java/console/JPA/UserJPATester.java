package console.JPA;

import infrastructure.user.UserDAO;
import infrastructure.user.qualifier.JPAUserQualifier;
import model.Type;
import model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Paul on 22.10.2015.
 */
public class UserJPATester {
    @Inject
    @JPAUserQualifier
    private UserDAO userDAO;

    public UserJPATester()throws ClassNotFoundException, SQLException{
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
        EntityManager entityManager = factory.createEntityManager();
    }

    public void execute() {
        System.out.println("-----JPA-TOPIC PRINTOUT:-----------------------------------------------");
        User user = new User(3, "ola@yahoo.no", "passord8", Type.STUDENT);
        User user2 = new User(4, "Gun@yahoo.no", "passord2", Type.TEACHER);
        User user3 = new User(5, "kei@yahoo.no", "passord3", Type.STUDENT);
        User user4 = new User(6, "lars@yahoo.no", "passord4", Type.TEACHER);
        User user5 = new User(7, "silje@yahoo.no", "passord5", Type.STUDENT);

        createUser(user);
        createUser(user2);
        createUser(user3);
        createUser(user4);
        createUser(user5);

        System.out.println("\n");
        getAllUsers();
        updateUser(new User(2, "Gun@yahoo.no", "passordrr", Type.STUDENT));
        getUserByID(4);
        System.out.println("\n");
        deleteAUser(4);
        getAllUsers();
    }

    public boolean createUser(User user){
        if(user!=null){
            userDAO.createUser(user);
            return true;
        }
        else
            return false;
    }

    public boolean updateUser(User user){
        if(user!=null){
            userDAO.updateUser(user);
            return true;
        }else
            return false;
    }

    public Optional<User> getUserByID(int id){
        if(id != 0){
            return userDAO.getUserById(id);
        }
        else
            return null;
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public boolean deleteAUser(int id) {
        return id != 0 && userDAO.deleteUser(id);
    }
}
