package pl.coderslab.game_objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Chest{

    private String name;
    private String description;
    private ItemsList treasure;

}
