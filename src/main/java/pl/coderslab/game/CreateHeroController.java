package pl.coderslab.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.HeroService;
import pl.coderslab.game_objects.Hero;
import javax.servlet.http.HttpServletRequest;

//This servlet is for registering new heroes
@Controller
@RequiredArgsConstructor
public class CreateHeroController {
    private final HeroService heroService;

    @GetMapping("/register")
    public String register() {

        return"register";
    }

    //In post we take the name and description from the register jsp
    //crate new hero with said name and description and pass it to the session
    //returns location1 where you play the game
    @PostMapping("/register")
    public String register(@RequestParam(name = "NewName") String newName, @RequestParam(name = "Desc") String desc, HttpServletRequest request){
        Hero player = new Hero();
        player.setName(newName);
        player.setDescription(desc);
        player.setHp(100);
        player.setLocationId(0);
        player.setPwr(15);
        heroService.saveHero(player);
        request.getSession().setAttribute("hero", player);
        request.getSession().setAttribute("location",player.getLocationId());
        return"redirect:location1";
    }
}
