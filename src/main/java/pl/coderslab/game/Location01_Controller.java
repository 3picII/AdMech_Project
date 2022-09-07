package pl.coderslab.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Direction;
import pl.coderslab.Tools;
import pl.coderslab.dao.EquipmentService;
import pl.coderslab.dao.HeroService;
import pl.coderslab.dao.ItemService;
import pl.coderslab.game_objects.Equipment;
import pl.coderslab.game_objects.Hero;
import pl.coderslab.game_objects.Room;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class Location01_Controller {
    private final HeroService heroService;
    private final EquipmentService equipmentService;
    private final ItemService itemService;
    private final Tools tools;
    static List<String> vocab = new ArrayList<>(Arrays.asList("n", "e", "s", "w", "look", "equip", "hit"));


    @GetMapping("/location1")
    public String location1() {
        return "mainGame";
    }


    @PostMapping("/location1")
    public String location1(@RequestParam(name = "command") String command, ModelMap model, HttpServletRequest request) {

        Hero player1 = (Hero) request.getSession().getAttribute("hero");

        if(player1 == null){
            model.addAttribute("text1","start");
        }else{
            switch (command) {
                default:
                    runCommand(command, player1);
                    break;
            }
            model.addAttribute("text1", look(player1));
        }
        return "mainGame";

    }

    private void moveHeroTo(Hero hero, int roomId) {
        hero.setLocationId(roomId);
        heroService.updateHero(hero);
    }

    public String showStr(String x) {
        return x;
    }

    private int moveTo(Hero hero, Direction x) {


        Room room = tools.mapOfRooms().get(hero.getLocationId());
        int exit;

        switch (x) {
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
        if (exit != Direction.NO_EXIT) {
            moveHeroTo(hero, exit);
        }
        return exit;
    }

    void moveHeroToDirection(Direction dir, Hero hero) {
        if (moveTo(hero, dir) == Direction.NO_EXIT) {
            System.out.println("No Exit");
        } else {
            look(hero);
        }
    }

    void goN(Hero hero) {
        moveHeroToDirection(Direction.NORTH, hero);
    }

    void goE(Hero hero) {
        moveHeroToDirection(Direction.EAST, hero);
    }

    void goS(Hero hero) {
        moveHeroToDirection(Direction.SOUTH, hero);
    }

    void goW(Hero hero) {
        moveHeroToDirection(Direction.WEST, hero);
    }

    public String look(Hero hero) {
        Room room = tools.mapOfRooms().get(hero.getLocationId());
        return showStr("You are in the " + room.description());
    }

    public String showEquipment(Hero hero) {
        Equipment equipment = equipmentService.findById(hero.getId());
        String show = equipment.toString();
        return show;
    }

    public String runCommand(String command, Hero hero) {
        List<String> wordlist;
        String s = "ok";
        String lowCommand = command.trim().toLowerCase();

        if (!lowCommand.equals("quit")) {
            if (lowCommand.equals("")) {
                s = "Please enter a command";
            } else {
                wordlist = wordList(lowCommand);
                s = parseCommand(wordlist, hero);
            }
        }
        return s;
    }

    public static List<String> wordList(String input) {
        String splitters = "[ \s,.:;?!\"']+";
        List<String> wordlist = new ArrayList<>();
        String[] words = input.split(splitters);

        for (String word : words) {
            wordlist.add(word);
        }
        return wordlist;
    }


    public  String parseCommand(List<String> wordlist, Hero hero) {
        List<String> command = new ArrayList<>();
        String error = "";
        String msg;

        for (String k : wordlist) {
            if (vocab.contains(k)) {
                if (true) {
                    command.add(k);
                }
            } else {
                error = "Sorry, I don't understand '" + k + "'";
            }
        }
        if (!error.isEmpty()) {
            msg = error;
        } else {
            msg = processCommand(command, hero);
        }
        return msg;
    }

    public String processCommand(List<String> command, Hero hero) {
        String s = "";

        if (command.size() == 0) {
            s = "No command detected";
        } else if (command.size() > 3) {
            s = "Command is to long";
        } else {
            switch (command.size()) {
                default:
                    s = processVerb(command, hero);
                    break;
            }
        }
        return s;
    }

    public String processVerb(List<String> commands, Hero hero) {
        String msg = "";

        switch (commands.get(0)) {
            case "n":
                goN(hero);
                break;

            case "e":
                goE(hero);
                break;

            case"s":
                goS(hero);
                break;

            case"w":
                goW(hero);
                break;
        }
        return msg;
    }
}
