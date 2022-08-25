package pl.coderslab.game_objects;

import javax.persistence.*;

@Entity
@Table(name=Equipment.TABLE_NAME)
public class Equipment {

    final static String TABLE_NAME = "equipment";

    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "item_1_id")
    private Item item1;
    @ManyToOne
    @JoinColumn(name = "item_2_id")
    private Item item2;
    @ManyToOne
    @JoinColumn(name = "item_3_id")
    private Item item3;
    @ManyToOne
    @JoinColumn(name = "item_4_id")
    private Item item4;

    public Item getItem4() {
        return item4;
    }

    public void setItem4(Item item4) {
        this.item4 = item4;
    }

    public Item getItem3() {
        return item3;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    @Override
    public String toString() {
        return "Equipment:\n" +
                "- " + item1 + "\n" +
                "- " + item2 + "\n" +
                "- " + item3 + "\n" +
                "- " + item4 + "\n" +
                "----------------";
    }
}
