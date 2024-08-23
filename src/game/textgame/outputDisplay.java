package game.textgame;

import java.util.Scanner;

public class outputDisplay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Your are walking in a forest.");
        String myWeapon;
        String myArmor;
        int myHP;

        myWeapon = "Axe";
        myArmor = "Leather Tunic";
        myHP = 10;

        in.nextLine();

        System.out.print("Your current weapon is " + myWeapon);
        in.nextLine();

        System.out.print("Your current armor is " + myArmor);
        in.nextLine();

        System.out.println("Your current HP is " + myHP);
        in.nextLine();

        System.out.println("A monster attacked you and gave 4 damage!");
        myHP -= 4;
        in.nextLine();

        System.out.print("Your current HP is " + myHP);

    }
}
