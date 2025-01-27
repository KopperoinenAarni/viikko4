package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cave implements Serializable {
    public static List<Monster> monsters;
        public Player player;
    
        public Cave(Player player) {
            this.monsters = new ArrayList<>();
            this.player = player;
        }
    
        public void addMonster(Monster monster) {
            monsters.add(monster);
        }
    
        public void listMonsters() {
            if (monsters.isEmpty()) {
                System.out.println("Luola on tyhjä.");
            }
            else {
                for (int i = 0; i < monsters.size(); i++) {
                monsters.get(i).printInfo(i);
                }
            }
        }
    
        public void attack(Monster monster) {
            player.attack(monster);
            System.out.println("Pelaaja " + player.getName() + " hyökkää " + monster.getType() + " hirviöön!");
            System.out.println("Hirviöllä " + monster.getType() + " on: " + monster.getHealth() + " jäljellä.");
        }
    
        public static void removeMonster(Monster monster) {
            monsters.remove(monster);
    }
}