package pl.coderslab.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StartController {

    //For now it just returns start jsp where you can choose to log in or register
    @GetMapping("/")
    public String start(){
        return "start";
    }
}
