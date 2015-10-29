package console.H2;

import model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Paul on 22.10.2015.
 */
public class Display_H2 {
    public void createHeader(){
        System.out.println("\n\t\t\t\t  ID\tEPOST\t\t\t\tPASSORD\t\t\tJOBBTYPE\n******************************************************************");
    }

    /// H2 DATABASE OUTPUT
    public void createUserH2(User user) {
        if (user != null) {
            System.out.format("H2 bruker opprettet: \t%d\t%s\t\t%s\t%s\n", user.getId(), user.getEmail(), user.getPassword(), user.getWorkType());
        }else
            System.err.println("Feil registrert, ingen bruker ble opprettet.");
    }

    public void updateUserH2(User user) {
        if (user !=null) {
            System.err.format("Oppdatert bruker i H2:\t%s\t%s\t\t%s\t%s\n", user.getId() , user.getEmail(), user.getPassword(), user.getWorkType());
        }else
            System.err.println("Ingen bruker ble oppdater , ingen bruker ble funnet..");
    }

    public void getUserByIdH2(Optional<User> userById) {
        if (userById.isPresent()) {
            System.out.format("Funnet bruker i H2:\t\t%s\t%s\t\t%s\t%s\n", userById.get().getId(), userById.get().getEmail(), userById.get().getPassword(), userById.get().getWorkType());
        }else
            System.err.println("Ingen bruker ble funnet med det id nummeret");
    }

    public void deleteUserH2(int id) {
        if (id != 0) {
            System.err.println("Bruker har blitt slettet fra H2 med id: " + id );
        }else
            System.out.println("Ingen bruker kunne slettes.. ");
    }

    public void getAllUsersH2(List<User> allUsers) {
        if (allUsers.size() > 0 || !allUsers.isEmpty()) {
            allUsers.forEach((user) -> System.out.format("Listet brukere i H2: \t%d\t%s\t\t%s\t%s\n", user.getId(), user.getEmail(), user.getPassword(), user.getWorkType()));
        }else
            System.err.println("Databasen er tom! ");
    }


}
