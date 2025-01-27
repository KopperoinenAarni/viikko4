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

    public void attack(Monster target) {
        target.takeDamage(10);
    }
}
