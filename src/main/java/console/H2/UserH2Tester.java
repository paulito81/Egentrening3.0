package console.H2;

import infrastructure.user.qualifier.H2DAOQualifier;
import infrastructure.user.UserDAO;
import model.Type;
import model.User;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by Paul on 22.10.2015.
 */
public class UserH2Tester {

    //PRINT OUT
    private Display_H2 displayH2 = new Display_H2();

    @Inject
    @H2DAOQualifier
    private UserDAO userDAO;

    UserH2Tester() {

    }

    public void execute() {
        System.out.println("-----H2 PRINTOUT:-----------------------------------------------");
        displayH2.createHeader();
        createUserH2(3, "ola@yahoo.no", "passord8", Type.STUDENT);
        createUserH2(4, "Gun@yahoo.no", "passord2", Type.TEACHER);
        createUserH2(5, "kei@yahoo.no", "passord3", Type.STUDENT);
        createUserH2(6, "lars@yahoo.no", "passord4", Type.TEACHER);
        createUserH2(7, "silje@yahoo.no", "passord5", Type.STUDENT);
        System.out.println("\n");
        getAllUsersH2();
        updateUserH2(new User(2, "Gun@yahoo.no", "passordrr", Type.STUDENT));
        getUserByIDH2(4);
        System.out.println("\n");
        deleteAUserH2(4);
        getAllUsersH2();

    }


    /*
        H2DATABASE
        CRUD OPERATIONS

     */
    public boolean createUserH2(int id, String email, String password, Type workType) {

        if (id != 0 || email != null || password != null || workType != null) {
            User user = new User(id, email, password, workType);

            userDAO.createUser(user);
            if (!userDAO.getAllUsers().isEmpty()) {
                displayH2.createUserH2(user);
            }
            return true;

        } else
            return false;
    }

    public boolean updateUserH2(User user) {
        if (user != null) {

            userDAO.updateUser(user);
            displayH2.updateUserH2(user);
            return true;
        } else
            return false;
    }

    public Optional<User> getUserByIDH2(int id) {
        if (id != 0) {
            displayH2.getUserByIdH2(userDAO.getUserById(id));
            return userDAO.getUserById(id);
        } else
            return null;
    }

    public List<User> getAllUsersH2() {

        displayH2.getAllUsersH2(userDAO.getAllUsers());

        return userDAO.getAllUsers();

    }

    public boolean deleteAUserH2(int id) {
        displayH2.deleteUserH2(id);
        return id != 0 && userDAO.deleteUser(id);
    }

}
