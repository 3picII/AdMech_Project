package pl.coderslab.game_objects;

import lombok.Getter;

import java.util.ArrayList;

public class ItemsList extends ArrayList<Item> {

    @Getter
    private String name;

    public ItemsList(String name) {
        super();
        this.name = name;
    }
}
