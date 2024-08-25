package game.ImproveUsingGUI;

import game.ImproveUsingGUI.monster.Monster_Goblin;
import game.ImproveUsingGUI.monster.Monster_Wizard;
import game.ImproveUsingGUI.monster.SuperMonster;
import game.ImproveUsingGUI.weapons.Weapon_Knife;
import game.ImproveUsingGUI.weapons.Weapon_LongSword;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vManger;
    Player player = new Player();
    SuperMonster monster;
    boolean silverRing;

    public Story(Game game, UI ui, VisibilityManager vManger) {
        this.game = game;
        this.ui = ui;
        this.vManger = vManger;
    }

    public void defaultSetUp(){
        player.hp = 10;
        ui.hpLabelNumber.setText(Integer.toString(player.hp));

        player.currentWeapon = new Weapon_Knife();
        ui.weaponLabelName.setText(player.currentWeapon.getName());

    }

    public void selectPosition(String nextPosition) {

        switch (nextPosition){
            case "townGate" -> townGate();
            case "talkToGuard" -> talkToGuard();
            case "attackGuard" -> attackGuard();
            case "crossRoad" -> crossRoad();
            case "north" -> north();
            case "east" -> east();
            case "west" -> west();
            case "fight" -> fight();
            case "playerAttack" -> playerAttack();
            case "monsterAttack" -> monsterAttack();
            case "lose" -> lose();
            case "win" -> win();
            case "toTitle" -> toTitle();
        }
    }

    public void townGate(){

        ui.mainTextArea.setText("You are at the gate of the town.\n" +
                "A guard is standing in front of you.\n\n" +
                "What do you want to do?");
        ui.button1.setText("Talk to the guard");
        ui.button2.setText("Attack the guard");
        ui.button3.setText("Leave");
        ui.button4.setText("");

        game.position1 = "talkToGuard";
        game.position2 = "attackGuard";
        game.position3 = "crossRoad";

        ui.button1.setVisible(true);
        ui.button2.setVisible(true);
        ui.button3.setVisible(true);
        ui.button4.setVisible(false);
    }

    public void talkToGuard(){
        if (silverRing){
            ending();
        } else {
            ui.mainTextArea.setText("Guard: Hello stranger. " +
                    "I have never seen your face." +
                    "\nI am sorry but we cannot let a stranger enter our town.");
            ui.button1.setText(">");
            ui.button2.setText("");
            ui.button3.setText("");
            ui.button4.setText("");

            game.position1 = "townGate";
        }
        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void attackGuard(){
        ui.mainTextArea.setText("Guard: Hey don't be stupid.\n\n" +
                "Guard fought back and hit you hard.\n" +
                "(You receive 3 damage)");
        player.setHp(-3,ui);
        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        if (player.hp > 0){
            game.position1 = "townGate";
        } else {
            game.position1 = "lose";
        }

        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void crossRoad(){

        ui.mainTextArea.setText("You are at a crossroad.\n" +
                "If you to south, you will go back to town");
        ui.button1.setText("Go north");
        ui.button2.setText("Go east");
        ui.button3.setText("Go south");
        ui.button4.setText("Go west");

        game.position1 = "north";
        game.position2 = "east";
        game.position3 = "townGate";
        game.position4 = "west";

        ui.button1.setVisible(true);
        ui.button2.setVisible(true);
        ui.button3.setVisible(true);
        ui.button4.setVisible(true);
    }

    public void north(){
        ui.mainTextArea.setText("There is a river.\n" +
                "You drink the water and rest at the riverside.");
        if (player.hp < 19) {
            ui.mainTextArea.append("\n\n(Your HP is recovered by 2)");
        }
        player.setHp(2,ui);
        ui.button1.setText("Go South");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        game.position1 = "crossRoad";

        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void east(){
        ui.mainTextArea.setText("You walked into the forest");

        if (player.currentWeapon.getName().equals("Knife")){
            ui.mainTextArea.append(" and found a Long Sword!");
            player.setCurrentWeapon(new Weapon_LongSword(), ui);
            ui.mainTextArea.append("\n\n(You obtain a Long Sword)");
        } else {
            ui.mainTextArea.append(".");
        }
        ui.button1.setText("Go west");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        game.position1 = "crossRoad";

        //VISIBILITY OF BUTTON
        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void west(){
        int i = new java.util.Random().nextInt(100);

        if (i < 90){
            monster = new Monster_Goblin();
        } else {
            monster = new Monster_Wizard();
        }

        if (monster.getHp() > 0 ){
            ui.mainTextArea.setText("You encounter a " + monster.getName() + "!");
            ui.button1.setText("Fight");
            ui.button2.setText("Run");
            ui.button2.setVisible(true);

            game.position1 = "fight";
            game.position2 = "crossRoad";

        } else {
            ui.mainTextArea.setText("You walked into the forest.");
            ui.button1.setText(">");
            ui.button2.setText("");
            ui.button2.setVisible(false);

            game.position1 = "crossRoad";
        }
        ui.button3.setText("");
        ui.button4.setText("");

        ui.button1.setVisible(true);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void fight(){
        ui.mainTextArea.setText(monster.toString());
        ui.mainTextArea.append("\n\nWhat do you do?");
        ui.button1.setText("Attack");
        ui.button2.setText("Run");
        ui.button3.setText("");
        ui.button4.setText("");

        game.position1 = "playerAttack";
        game.position2 = "crossRoad";

        ui.button1.setVisible(true);
        ui.button2.setVisible(true);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void playerAttack(){
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.getDamage());

        ui.mainTextArea.setText("You attacked the " + monster.getName()
                + " and give " + playerDamage + " damage!");
        monster.setHp(-playerDamage);

        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        if (monster.getHp() < 1){
            game.position1 = "win";
        }else{
            game.position1 = "monsterAttack";
        }

        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void monsterAttack(){
        int monsterDamage = (int) (Math.random()* monster.getAttack());

        ui.mainTextArea.setText( monster.getAttackMessage()
                + "\nYou received "
                + monsterDamage + " damage!");
        player.setHp(-monsterDamage,ui);

        ui.button1.setText(">");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        if (player.hp < 1){
            game.position1 = "lose";
        } else {
            game.position1 ="fight";
        }

        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void win(){
        ui.mainTextArea.setText("You've defeated the " + monster.getName() +
                "!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
        silverRing = true;

        ui.button1.setText("Go east");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        game.position1 = "crossRoad";

        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void lose(){
        ui.mainTextArea.setText("You are Dead!\n\n<GAME OVER>");

        ui.button1.setText("START AGAIN!");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");

        game.position1 = "toTitle";

        ui.button1.setVisible(true);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void ending(){
        ui.mainTextArea.setText("Guard: Oh you killed that goblin!!\n" +
                "Thank you so much. you are a true hero!" +
                "\nWelcome to our town!\n\n<THE END>");

        ui.button1.setText("");
        ui.button2.setText("");
        ui.button3.setText("");
        ui.button4.setText("");
        ui.button1.setVisible(false);
        ui.button2.setVisible(false);
        ui.button3.setVisible(false);
        ui.button4.setVisible(false);
    }

    public void toTitle(){
        defaultSetUp();
        vManger.showTitleScreen();
    }


}
