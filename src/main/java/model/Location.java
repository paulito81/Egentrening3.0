package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Paul on 22.10.2015.
 */
@Entity
public class Location {

    @Id

    @NotNull @Min(1)
    private int rooms;
    @NotNull
    private String buildingName;

    @JoinTable
    @OneToMany
    List<Topic> topicList;

    public Location(){
    }

    public Location(int rooms, String buildingName) {
        this.rooms = rooms;
        this.buildingName = buildingName;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }


}
