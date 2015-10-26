package model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Paul on 23.10.2015.
 */
@Entity
public class Topic {

    @Id
    int id;
    @NotNull
    String name;

    @Min(0) @Max(100)
    @ManyToMany
    @JoinTable
    List<User> numberOfUsers;

    @ManyToOne
    @JoinTable
    Location location;

    public Topic(int id, String name, List<User> numberOfUsers) {
        this.id = id;
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public Topic(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Topic(){

    }


    public List<User> getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(List<User> numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
