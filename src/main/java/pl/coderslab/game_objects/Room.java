package pl.coderslab.game_objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
public class Room {

    private String name;
    private String description;
    private int north, east, south, west;
    private Chest chest;

    public Room(String name, String description, int north, int east, int south, int west) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public Room(String name, String description, int north, int east, int south, int west, Chest chest) {
        this.name = name;
        this.description = description;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.chest = chest;
    }

    public String description(){
        String roomdesc;

        roomdesc = getName() + ": " + getDescription();
        return roomdesc;
    }
}
