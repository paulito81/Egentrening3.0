package model;

/**
 * Created by Paul on 22.10.2015.
 */
public class Location {


    private int rooms;
    private String buildingName;

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
