package pl.coderslab.game_objects;

import lombok.Data;


@Data
public class Entity {
    //Entity ma być wyjściowym modelem do wszystkiego, ma nazwę oraz opis, później dodam do niej pewnie
    //jeszcze jakieś metody

    private String name;

    private String description;


    public Entity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
