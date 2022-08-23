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


    public String description(){
        String roomdesc;

        roomdesc = getName() + ": " + getDescription();
        return roomdesc;
    }
}
