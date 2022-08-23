package pl.coderslab;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import pl.coderslab.dao.ItemService;
import pl.coderslab.game_objects.Item;

@Controller
@RequiredArgsConstructor
public class TestController {
//    private final ItemService itemService;

    @RequestMapping("/hello")
    public String addItem(){

//        Item item = new Item();
//        item.setName("Miecz");
//        item.setDescription("Na prawdę potężny miecz");
//        item.setPower(10);
//        item.setType(1);
//        itemService.saveItem(item);
        return "test/add";
    }
}
