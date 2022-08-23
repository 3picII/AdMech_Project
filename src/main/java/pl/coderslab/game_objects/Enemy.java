package pl.coderslab.game_objects;

import lombok.Getter;
import lombok.Setter;

public class Enemy extends Entity{

    //Model przeciwnika

    @Getter
    @Setter
    private int hp;

    @Getter
    @Setter
    private int attackPower;

    public Enemy(String name, String description) {
        super(name, description);
    }

    public Enemy(String name, String description, int hp, int attackPower) {
        super(name, description);
        this.hp = hp;
        this.attackPower = attackPower;
    }

}
