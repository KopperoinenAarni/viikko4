package main;

import java.io.Serializable;

public class Player implements Serializable{
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

    public static void attack(Monster monster) {
        monster.takeDamage(10);
        
    } 
}
