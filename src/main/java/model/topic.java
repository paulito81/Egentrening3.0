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
@NamedQueries(value = {
        @NamedQuery(name = "Topic.getAllUsers", query = "select t from Topic t"),
        @NamedQuery(name = "Topic.deleteTopic", query = "delete from Topic t where t.id = :id "),

})
@SequenceGenerator(name = "Topic.sequence", sequenceName = "SEQ_USER", initialValue = 50)
public class Topic {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Topic.sequence")
    int id;
    @NotNull
    String name;

    @Min(0)
    @Max(100)
    @ManyToMany
    @JoinTable
    List<User> numberOfUsers;

    @ManyToOne
    @JoinColumn(name = "FK_LOCATION_ID")
    Location location;

    public Topic(int id, String name, List<User> numberOfUsers) {
        this.id = id;
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public Topic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic() {

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


    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                ", location=" + location +
                '}';
    }


}
