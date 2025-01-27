package main;

import java.io.Serializable;

public class Monster implements Serializable {
    private String type;
    private int health;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public Monster(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public void printInfo(int index) {
        index = index + 1;
        System.out.println(index + ": " + type + " / " + health + "HP");
    }

    public void codegrade() {
        System.out.println("muutos, jotta voi git pushata");
    }
}

