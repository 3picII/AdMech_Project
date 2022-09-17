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

//This is the main class that wraps up all the functionalities into interactive game

@Controller
@RequiredArgsConstructor
public class Location01_Controller {
    private final HeroService heroService;
    private final EquipmentService equipmentService;
    private final ItemService itemService;
    private final Tools tools;

    //List of available commands
    static List<String> vocab = new ArrayList<>(Arrays.asList("n", "e", "s", "w"));

    //Get displays mainGame jsp where you enter commands (for now, only n, e, s, w)

    @GetMapping("/location1")
    public String location1() {
        return "mainGame";
    }

    //Post: here we capture data from our input field and process it to do specific command

    @PostMapping("/location1")
    public String location1(@RequestParam(name = "command") String command, ModelMap model, HttpServletRequest request) {

        //Request hero object form session
        Hero player1 = (Hero) request.getSession().getAttribute("hero");

        //pass command to runCommand class if we have player as hero object,
        //if not returns: no user. After that return mainGame jsp
        if(player1 == null){
            model.addAttribute("text1","no user");
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

    //Takes your character and room Id to update characters location id in database
    private void moveHeroTo(Hero hero, int roomId) {
        hero.setLocationId(roomId);
        heroService.updateHero(hero);
    }

    //Used only once in look class, returns given string
    public String showStr(String x) {
        return x;
    }

    //gets your chero and it's direction to check and
    //if present get another room id for moving your hero there
    private int moveTo(Hero hero, Direction x) {

        //create room object of room where your hero is right now
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

    //if there is an exit for this direction, execute look method
    void moveHeroToDirection(Direction dir, Hero hero) {
        if (moveTo(hero, dir) == Direction.NO_EXIT) {
            System.out.println("No Exit");
        } else {
            look(hero);
        }
    }

    //All four go methods are for passing specific directions
    //and hero object to moveHeroToDirection method
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

    //Returns a room description as a String
    public String look(Hero hero) {
        Room room = tools.mapOfRooms().get(hero.getLocationId());
        return showStr("You are in the " + room.description());
    }

    //Not implemented yet
    public String showEquipment(Hero hero) {
        Equipment equipment = equipmentService.findById(hero.getId());
        String show = equipment.toString();
        return show;
    }

    //first method that hava contact with command from user
    //checks if command exists or if it equals quit
    //if not passes command to wordList method
    //there it's divided into single commands
    //(processing more than one command is a future concept for now,
    // at first I will focus on implementing more functionalities to existing one command model)
    //after wordList the command as a List is passed to parseCommand
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

    //here we check if our wordList contains only those words that you can use in game
    //if so it's passed down to processCommand with hero object
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

    //In here we check if wordList of our command exists,
    //is too long or if it's just the right size
    //(as well as processing more command in runCommand as well here it will be implemented but in the future)
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

    //The last method in this class is processVerb where it takes wordList and your hero
    //to pass it to switch statement pass specific command
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
