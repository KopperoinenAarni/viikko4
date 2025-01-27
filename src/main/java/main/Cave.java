
package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cave implements Serializable {
    public List<Monster> monsters;
        public Player player;
    
        public Cave(Player player) {
            this.monsters = new ArrayList<>();
            this.player = player;
        }
    
        public void addMonster(Monster monster) {
            monsters.add(monster);
        }
        public List<Monster> getMonsters() {
            return monsters;
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
            player.attack(monster, monsters);
            System.out.println(player.getName() + " hyökkää " + monster.getType() + " hirviöön!");
            if (monster.getHealth() <= 0) {
                System.out.println(monster.getType() + " on kuollut!");
            } else {
                System.out.println("Hirviöllä on " + monster.getHealth() + " elämää jäljellä.");
            }
        }
    
        public void removeMonster(Monster monster) {
            monsters.remove(monster);
    }
        public void codegrade() {
        System.out.println("muutos, jotta voi git pushata");
    }
}
