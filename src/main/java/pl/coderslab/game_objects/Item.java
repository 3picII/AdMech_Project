package pl.coderslab.game_objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = Item.TABLE_NAME)
@Data
@AllArgsConstructor
public class Item {

    final static String TABLE_NAME = "items";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int type; //Typ przedmiotu: 1 - przedmiot dodający siłę ataku, 2 - przedmiot zwiększający hp

    private int power;

    public Item() {
    }


}
