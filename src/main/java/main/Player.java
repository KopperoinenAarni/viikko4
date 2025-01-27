package main;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Player implements Serializable {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void attack(Monster monster, List<Monster> monsters) {
        monster.takeDamage(10);
        if (monster.getHealth() <= 0) {
            Iterator<Monster> iterator = monsters.iterator();
            while (iterator.hasNext()) {
                Monster m = iterator.next();
                if (m.equals(monster)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }
}