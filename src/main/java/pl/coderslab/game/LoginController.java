package pl.coderslab.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.HeroService;
import pl.coderslab.game_objects.Hero;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final HeroService heroService;

    @GetMapping("/login")
    public String login() {

        return"login";
    }

    //Uses custom method from heroService to find your saved character in database
    //to get it and pass into the session for further gameplay
    @PostMapping("/login")
    public String login(@RequestParam(name = "EName") String eName, HttpServletRequest request){

        request.getSession().setAttribute("hero",heroService.findByName(eName));
        return"redirect:location1";
    }
}
