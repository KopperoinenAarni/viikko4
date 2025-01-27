package main;
import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Syötä pelaajan nimi: ");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);

        Cave cave = new Cave(player);

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch (i) {
                    case 1:
                        System.out.println("Anna hirviön tyyppi: ");
                        String setMonsterType = sc.nextLine();
                        System.out.println("Anna hirviön elämän määrä numerona: ");
                        int setMonsterHealth = Integer.parseInt(sc.nextLine());
                        Monster newMonster = new Monster(setMonsterType, setMonsterHealth);
                        cave.addMonster(newMonster);
                        break;

                    case 2:
                        cave.listMonsters();
                        break;

                    case 3:
                        System.out.println("Valitse hirviö, johon hyökätä: ");
                        cave.listMonsters();
                        int type = Integer.parseInt(sc.nextLine()) - 1;
                        if (type >= 0 && type < cave.monsters.size()) {
                            cave.attack(cave.monsters.get(type));
                        } else {
                            System.out.println("Virheellinen valinta.");
                        }
                        break;

                    case 4:
                        System.out.println("Anna tiedoston nimi, johon peli tallentaa: ");
                        String fileName = sc.nextLine();
                        saveGame(cave, fileName);
                        break;

                    case 5:
                        System.out.println("Anna tiedoston nimi, josta peli ladataan: ");
                        String loadFileName = sc.nextLine();
                        cave = loadGame(loadFileName);
                        break;

                    case 0:
                        exit = true;
                        System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                        break;

                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                }
            }
        }
        sc.close();
    }

    public static void saveGame(Cave cave, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(cave);
            System.out.println("Peli tallennettiin tiedostoon " + fileName + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cave loadGame(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Cave cave = (Cave) ois.readObject();
            System.out.println("Peli ladattu tiedostosta " + fileName + ". Tervetuloa takaisin, " + cave.player.getName() + ".");
            return cave;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}