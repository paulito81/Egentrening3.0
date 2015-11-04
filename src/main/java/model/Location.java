package model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Paul on 22.10.2015.
 */
@Entity

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull @Min(1)
    private int room;
    @NotNull
    private String buildingName;


    public Location(int id, int room, String buildingName) {
        this.id = id;
        this.room = room;
        this.buildingName = buildingName;
    }


    public Location(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getRoom() {
        return room;
    }

    public void setRoom(int rooms) {
        this.room = rooms;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }


}
