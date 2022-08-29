package pl.coderslab.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.HeroService;
import pl.coderslab.game_objects.Hero;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final HeroService heroService;

    @GetMapping("/login")
    public String login() {

        return"login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "EName") String eName, HttpServletRequest request){
        //request.getSession().setAttribute("hero", );
        return"redirect:location1";
    }
}
