package pl.coderslab.game_objects;

import lombok.Getter;
import lombok.Setter;

public class Chest extends Entity{

    @Getter
    @Setter
    private ItemsList treasure;

    public Chest(String name, String description, ItemsList treasure) {
        super(name, description);
        this.treasure = treasure;
    }
}
