package pl.coderslab.game_objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
public class Room {

    //Direction integers are the id of neighbouring room
    //for example:      -------       -------
    //                 |   1   | --- |   2   |
    //                  -------      -------
    //                                  |
    //                                -------
    //                               |   3   |
    //                                -------
    //
    //        north |  east  |  south  | west
    //Room1 (no_exit,   2    ,  no_exit, no_exit)
    //Room2 (no_exit, no_exit,    3    ,    1   )
    //Room3 (   2   , no_exit,  no_exit, no_exit)
    private String name;
    private String description;
    private int north, east, south, west;
    private Chest chest;

//    If there is enemy in given room int = 1 if not int = 0
    private int enemy;

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

    public String description() {
        String roomdesc;

        roomdesc = getName() + ": " + getDescription();
        return roomdesc;
    }
}
