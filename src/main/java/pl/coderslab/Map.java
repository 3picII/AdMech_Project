package pl.coderslab;

import pl.coderslab.game_objects.Chest;
import pl.coderslab.game_objects.Room;

import java.util.ArrayList;

public class Map {

    public ArrayList<Room> mapOfRooms(){

        Chest chest = new Chest();

        ArrayList<Room> map = new ArrayList<>();
        map.add(new Room("Room0","Room0",1,-1,-1,-1, chest));
        map.add(new Room("Room1","Room1",-1,2,0,3));
        map.add(new Room("Room2","Room2", 6,-1,-1,1));
        map.add(new Room("Room3","Room3",4,1,-1,-1));
        map.add(new Room("Room4","Room4",7,5,3,-1));
        map.add(new Room("Room5","Room5",-1,-1,-1,4));
        map.add(new Room("Room6","Room6",8,-1,2,-1));
        map.add(new Room("Room7", "Room7",-1,8,4,-1));
        map.add(new Room("Room8","Room8",10,9,6,7));
        map.add(new Room("Room9","Room9",-1,-1,14,8));
        map.add(new Room("Room10","Room10",-1,-1,8,11));
        map.add(new Room("Room11","Room11",12,10,-1,-1));
        map.add(new Room("Room12","Room12",13,-1,11,-1));
        map.add(new Room("Room13","Room13",-1,-1,12,-1));
        map.add(new Room("Room14","Room14",9,-1,15,-1));
        map.add(new Room("Room15","Room15",14,-1,16,-1));
        map.add(new Room("Room16","Room16",15,-1,-1,-1));

        return map;
    }
}
