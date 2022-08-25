package pl.coderslab;

import org.springframework.stereotype.Repository;
import pl.coderslab.game_objects.Chest;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Hero;
import pl.coderslab.game_objects.Room;

import javax.persistence.Entity;
import java.util.ArrayList;

@Repository
public class Map {

    public ArrayList<Room> mapOfRooms(){

        Chest chest = new Chest();

        ArrayList<Room> map = new ArrayList<>();
        map.add(new Room("Room0","Room0",1,Direction.NO_EXIT,Direction.NO_EXIT,Direction.NO_EXIT, chest));
        map.add(new Room("Room1","Room1",Direction.NO_EXIT,2,0,3));
        map.add(new Room("Room2","Room2", 6,Direction.NO_EXIT,Direction.NO_EXIT,1));
        map.add(new Room("Room3","Room3",4,1,Direction.NO_EXIT,Direction.NO_EXIT));
        map.add(new Room("Room4","Room4",7,5,3,Direction.NO_EXIT));
        map.add(new Room("Room5","Room5",Direction.NO_EXIT,Direction.NO_EXIT,Direction.NO_EXIT,4));
        map.add(new Room("Room6","Room6",8,Direction.NO_EXIT,2,Direction.NO_EXIT));
        map.add(new Room("Room7", "Room7",Direction.NO_EXIT,8,4,Direction.NO_EXIT));
        map.add(new Room("Room8","Room8",10,9,6,7));
        map.add(new Room("Room9","Room9",Direction.NO_EXIT,Direction.NO_EXIT,14,8));
        map.add(new Room("Room10","Room10",Direction.NO_EXIT,Direction.NO_EXIT,8,11));
        map.add(new Room("Room11","Room11",12,10,Direction.NO_EXIT,Direction.NO_EXIT));
        map.add(new Room("Room12","Room12",13,Direction.NO_EXIT,11,Direction.NO_EXIT));
        map.add(new Room("Room13","Room13",Direction.NO_EXIT,Direction.NO_EXIT,12,Direction.NO_EXIT));
        map.add(new Room("Room14","Room14",9,Direction.NO_EXIT,15,Direction.NO_EXIT));
        map.add(new Room("Room15","Room15",14,Direction.NO_EXIT,16,Direction.NO_EXIT));
        map.add(new Room("Room16","Room16",15,Direction.NO_EXIT,Direction.NO_EXIT,Direction.NO_EXIT));

        return map;
    }


}
