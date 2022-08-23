package pl.coderslab.game_objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Data
@Table(name = Hero.TABLE_NAME)
@AllArgsConstructor
public class Hero{

    final static String TABLE_NAME="hero";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int hp;
    private int locationId;
    @OneToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public Hero() {
    }
}
