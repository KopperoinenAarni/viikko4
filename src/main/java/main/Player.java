package main;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Player implements Serializable {
    private String name;

    Cave cave = new Cave(this);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public boolean attack(Monster monster) {
        monster.takeDamage(10);
        System.out.println(this.name + " hyökkää " + monster.getType() + " hirviöön!");
        if (monster.getHealth() <= 0) {
            System.out.println(monster.getType() + " on kuollut!");
            return true;
        } else {
            System.out.println("Hirviöllä on " + monster.getHealth() + " elämää jäljellä.");
        }
        return false;
    }
}