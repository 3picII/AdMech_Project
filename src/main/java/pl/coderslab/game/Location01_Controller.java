package pl.coderslab.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Direction;
import pl.coderslab.Map;
import pl.coderslab.dao.EquipmentService;
import pl.coderslab.dao.HeroService;
import pl.coderslab.dao.ItemService;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Hero;
import pl.coderslab.game_objects.Room;

@Controller
@RequiredArgsConstructor
public class Location01_Controller {
    private final HeroService heroService;
    private final EquipmentService equipmentService;
    private final ItemService itemService;
    private final Map map;
    Hero player = temporaryPlayer();

    @ResponseBody
    @RequestMapping("/location1")
    public String location1(){
        Room room = map.mapOfRooms().get(3);
        String zxc = room.toString();
        String zxcv = room.description();
        Hero hero = new Hero();
        return zxc + " " + zxcv;
    }

    public Hero temporaryPlayer(){
        Hero player = new Hero("John","Yet another tech priest from mars",100,15,0);
        return player;
    }


    private void moveHeroTo(Hero hero, int roomId){
        hero.setLocationId(roomId);
        heroService.updateHero(hero);
    }

    void showStr(String x){
        System.out.println(x);
    }
    private int moveTo(Hero hero, Direction x){


        Room room = map.mapOfRooms().get(hero.getLocationId());
        int exit;

        switch(x){
            case NORTH:
                exit = room.getNorth();
                break;
            case EAST:
                exit = room.getEast();
                break;
            case SOUTH:
                exit = room.getSouth();
                break;
            case WEST:
                exit = room.getWest();
                break;
            default:
                exit = Direction.NO_EXIT;
                break;
        }
        if(exit != Direction.NO_EXIT){
            moveHeroTo(hero,exit);
        }
        return exit;
    }

    void moveHeroToDirection(Direction dir){
        if(moveTo(player,dir)==Direction.NO_EXIT){
            System.out.println("No Exit");
        }else {
            look();
        }
    }

    void goN(){
        moveHeroToDirection(Direction.NORTH);
}
    void goE(){
        moveHeroToDirection(Direction.EAST);
}
    void goS(){
        moveHeroToDirection(Direction.SOUTH);
}
    void goW(){
        moveHeroToDirection(Direction.WEST);
}

    void look() {
        Room room = map.mapOfRooms().get(player.getLocationId());
        showStr("You are in the " + room.description());
    }

    public String showEquipment(Hero hero){
        Equipment equipment = equipmentService.findById(hero.getId());
        String show = equipment.toString();
        return show;
    }

}
