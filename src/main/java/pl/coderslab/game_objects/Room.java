package pl.coderslab.game_objects;

import lombok.Getter;
import lombok.Setter;


public class Room extends Entity{

    @Getter
    @Setter
    private int north, east, south, west;

    @Getter
    @Setter
    private Chest chest;

    public Room(String name, String description, int north, int east, int south, int west, Chest chest) {
        super(name, description);
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
