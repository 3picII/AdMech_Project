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
    Hero player = temporaryPlayer();
//    HttpServletRequest request;
//    Hero player1 = (Hero) request.getSession().getAttribute("hero");

    @GetMapping("/location1")
    public String location1() {
        return "mainGame";
    }


    @PostMapping("/location1")
    public String location1(@RequestParam(name = "command") String command, ModelMap model) {

        switch (command) {
            default:
                runCommand(command);
                break;
        }
        model.addAttribute("text1", look());

        return "mainGame";

    }

    public Hero temporaryPlayer() {
        Hero player = new Hero("John", "Yet another tech priest from mars", 100, 15, 0);
        return player;
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

    void moveHeroToDirection(Direction dir) {
        if (moveTo(player, dir) == Direction.NO_EXIT) {
            System.out.println("No Exit");
        } else {
            look();
        }
    }

    void goN() {
        moveHeroToDirection(Direction.NORTH);
    }

    void goE() {
        moveHeroToDirection(Direction.EAST);
    }

    void goS() {
        moveHeroToDirection(Direction.SOUTH);
    }

    void goW() {
        moveHeroToDirection(Direction.WEST);
    }

    public String look() {
        Room room = tools.mapOfRooms().get(player.getLocationId());
        return showStr("You are in the " + room.description());
    }

    public String showEquipment(Hero hero) {
        Equipment equipment = equipmentService.findById(hero.getId());
        String show = equipment.toString();
        return show;
    }

    public String runCommand(String command) {
        List<String> wordlist;
        String s = "ok";
        String lowCommand = command.trim().toLowerCase();

        if (!lowCommand.equals("quit")) {
            if (lowCommand.equals("")) {
                s = "Please enter a command";
            } else {
                wordlist = wordList(lowCommand);
                s = parseCommand(wordlist);
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


    public  String parseCommand(List<String> wordlist) {
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
            msg = processCommand(command);
        }
        return msg;
    }

    public String processCommand(List<String> command) {
        String s = "";

        if (command.size() == 0) {
            s = "No command detected";
        } else if (command.size() > 3) {
            s = "Command is to long";
        } else {
            switch (command.size()) {
                default:
                    s = processVerb(command);
                    break;
            }
        }
        return s;
    }

    public String processVerb(List<String> commands) {
        String msg = "";

        switch (commands.get(0)) {
            case "n":
                goN();
                break;

            case "e":
                goE();
                break;

            case"s":
                goS();
                break;

            case"w":
                goW();
                break;
        }
        return msg;
    }
}
