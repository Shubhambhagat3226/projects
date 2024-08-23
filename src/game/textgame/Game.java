package game.textgame;

import java.util.Scanner;

public class Game {
    int playerHp;
    String playerWeapon;
    String playerName;
    int choice;
    Scanner inputScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);
    int monsterHP;
    boolean silverRing;

    public void getPlayerHp() {
        System.out.println("Your HP: " + playerHp);
    }

    public void getPlayerWeapon() {
        System.out.println("Your Weapon : " + playerWeapon);
    }

    public void getMonsterHP() {
        System.out.println("Monster HP: " + monsterHP);
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.playerSetUp();
        game.townGate();
    }

    public void playerSetUp(){
        playerHp = 10;
        playerWeapon = "Knife";
        monsterHP = 15;

        getPlayerHp();
        getPlayerWeapon();

        System.out.println("please enter your name: ");
        playerName = inputScanner.next();

        System.out.printf("Hello %s, Let's start your adventure!",playerName);
        enterScanner.nextLine();

    }

    public void townGate(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.print("You are at the gate of the town.");
        enterScanner.nextLine();
        System.out.println("A guard is standing in front of you.");
        enterScanner.nextLine();
        System.out.println("What do you want to do?\n" +
                "1: Talk to the guard\n" +
                "2: Attack the guard\n" +
                "3: Leave");
        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();

        if (choice == 1){
            if (silverRing){
                ending();
            } else {
                System.out.print("Guard: Hello there stranger.");
                enterScanner.nextLine();
                System.out.print("So your name is " + playerName + "?");
                enterScanner.nextLine();
                System.out.print("Sorry but we can let stranger enter our town.");
                enterScanner.nextLine();
                townGate();
            }
        }
        else if (choice == 2){
            System.out.println("Guard: Hey don't be stupid.");
            enterScanner.nextLine();
            System.out.print("The guard hit you so hard and you give up.\n" +
                    "(You receive 1 damage)");
            enterScanner.nextLine();
            playerHp -= 1;
            getPlayerHp();
            enterScanner.nextLine();
            townGate();
        } else if (choice == 3){
            System.out.print("You leave the town for new adventure.");
            enterScanner.nextLine();
            crossRoad();
        } else {
            townGate();
        }
    }

    public void crossRoad(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.println("You are at a crossroad.");
        enterScanner.nextLine();
        System.out.println("If you to south, you will go back to town");
        System.out.println("1: Go North\n" +
                "2: Go East\n" +
                "3: Go West\n" +
                "4: Go South\n");

        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();

        switch (choice){
            case 1 -> north();
            case 2 -> east();
            case 3 -> west();
            case 4 -> townGate();
            default -> crossRoad();
        }
    }

    public void north(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.print("There is a river.");
        enterScanner.nextLine();
        System.out.println("You drink the water and rest at the riverside.");
        if (playerHp <= 10){
            System.out.println("(Your HP is recovered)");
            enterScanner.nextLine();
            playerHp += 1;
            getPlayerHp();
        }
        enterScanner.nextLine();
        System.out.println("1: Go back to the crossroad");
        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();
        if (choice == 1) {
            crossRoad();
        } else {
            north();
        }
    }

    public void east(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.println("You walked into the forest.");
        enterScanner.nextLine();
        if (!playerWeapon.equals("Long sword")){
            System.out.println("There you found long sword!");
            playerWeapon = "Long sword";
            getPlayerWeapon();
            enterScanner.nextLine();
        }
         System.out.println("1: Go back to the crossroad");

        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();
        if (choice == 1) {
            crossRoad();
        } else{
            east();
        }
    }

    public void west(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.print("You walked into the forest.");
        enterScanner.nextLine();
        System.out.println("\nYou see a goblin!\n");
        System.out.println("1: Fight\n" +
                "2: Run");
        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();
        if (choice == 1){
            fight();
        } else if (choice == 2){
            System.out.println("You escape from the forest.");
            enterScanner.nextLine();
            crossRoad();
        } else {
            west();
        }
    }

    public void fight(){
        System.out.println("\n-------------------------------------------------\n");
        getPlayerHp();
        getMonsterHP();

        System.out.println();
        System.out.println("1: Attack" +
                "\n2: Run");
        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();
        if (choice == 1){
            attack();
        } else if (choice == 2) {
            crossRoad();
        } else {
            fight();
        }
    }
    public void attack(){
        int playerDamage;
        int weaponDamage = 1;
        if (playerWeapon.equals("Knife")){
            weaponDamage = 5;
        } else if (playerWeapon.equals("Long sword")){
            weaponDamage = 8;
        }
        playerDamage = new  java.util.Random().nextInt(weaponDamage);

        System.out.printf("You attacked the monster and give %d damage!\n",playerDamage);

        monsterHP -= playerDamage;
//        getMonsterHP();

        if (monsterHP < 1){
            win();
        } else {
            int monsterDamage = (int) Math.floor(Math.random()*5);

            System.out.printf("Monster attack you and give %d damage\n",monsterDamage);
            playerHp -= monsterDamage;

//            getPlayerHp();
            if (playerHp < 1){
                dead();
            } else {
                fight();
            }
        }
    }

    public void dead(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.println("You are dead!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("\n-------------------------------------------------\n");
    }

    public void win(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.println("You killed the monster!");
        System.out.println("The monster drop the ring!");
        System.out.println("You obtain a Silver Ring!\n\n");
        silverRing = true;
        System.out.println("1: go crossroad");
        System.out.println("\n-------------------------------------------------\n");

        choice = inputScanner.nextInt();
        if (choice == 1){
            crossRoad();
        } else {
            win();
        }
    }

    public void ending(){
        System.out.println("\n-------------------------------------------------\n");
        System.out.println("Guard: Oh you killed that goblin?? Great!");
        enterScanner.nextLine();
        System.out.println("Guard: It seems you are trustworthy guy. Welcome to our town!");
        System.out.println("\n\n               THE END                  ");
        System.out.println("\n-------------------------------------------------\n");
    }
}
