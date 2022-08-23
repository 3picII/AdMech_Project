package pl.coderslab.game_objects;

import lombok.Getter;
import lombok.Setter;

public class Hero extends Enemy{

    //Hero dziedziczy po enemy, jedyną różnicą jest ekwipunek oraz
    //numer lokacji aby umożliwić zapis poprzez checkpointy

    @Getter
    @Setter
    private ItemsList equipment;

    @Getter
    @Setter
    private int locationNumber;

    public Hero(String name, String description, int hp, int attackPower, ItemsList equipment, int locationNumber) {
        super(name, description, hp, attackPower);
        this.equipment = equipment;
        this.locationNumber = locationNumber;
    }
}
