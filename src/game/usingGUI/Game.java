package game.usingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * adding same window panel
 * for our text game
 * to make attractive
 * */
public class Game {
    String position;

    StartScreen startScreen;
    TitleScreenHandler action = new TitleScreenHandler();
    choiceHandler choiceHandler = new choiceHandler();
    PlayerDetail playerDetail;

    JFrame window;
    Container container;
    JPanel mainTextPanel, choicePanel;
    JTextArea mainTextArea;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 27);
    JButton button1, button2, button3, button4;


    public Game(){
        window = new JFrame("ADVENTURE GAME");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();

        startScreen = new StartScreen();

        startScreen.startButton.addActionListener(action);
        container.add(startScreen.titleNamePanel);
        container.add(startScreen.startButtonPanel);
    }

    public static void main(String[] args) {
        Game game = new Game();
    }


    public void createGameScreen(){

        startScreen.titleNamePanel.setVisible(false);
        startScreen.startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        container.add(mainTextPanel);
        mainTextPanel.setVisible(true);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);

        choiceArea();

        playerDetail = new PlayerDetail();
        container.add(playerDetail.playerPanel);

        townGate();
    }

    public void townGate(){
        position = "townGate";

        mainTextArea.setText("You are at the gate of the town.\n" +
                "A guard is standing in front of you.\n\n" +
                "What do you want to do?");
        button1.setText("Talk to the guard");
        button2.setText("Attack the guard");
        button3.setText("Leave");
        button4.setText("");
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(false);
    }

    public void talkToGuard(){
        position = "talkToGuard";

        mainTextArea.setText("Guard: Hello stranger. " +
                "I have never seen your face." +
                "\nI am sorry but we cannot let a stranger enter our town.");
        button1.setText(">");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void choiceArea(){
        choicePanel = new JPanel();
        choicePanel.setBounds(250,350,300,150);
        choicePanel.setBackground(Color.black);
        choicePanel.setLayout(new GridLayout(4,1));
        container.add(choicePanel);

        button1 =new JButton("Choice 1");
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button1.setFont(normalFont);
        button1.setFocusPainted(false);
        button1.addActionListener(choiceHandler);
        button1.setActionCommand("c1");
        choicePanel.add(button1);

        button2 =new JButton("Choice 2");
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.setFont(normalFont);
        button2.setFocusPainted(false);
        button2.addActionListener(choiceHandler);
        button2.setActionCommand("c2");
        choicePanel.add(button2);

        button3 =new JButton("Choice 3");
        button3.setBackground(Color.black);
        button3.setForeground(Color.white);
        button3.setFont(normalFont);
        button3.setFocusPainted(false);
        button3.addActionListener(choiceHandler);
        button3.setActionCommand("c3");
        choicePanel.add(button3);

        button4 =new JButton("Choice 4");
        button4.setBackground(Color.black);
        button4.setForeground(Color.white);
        button4.setFont(normalFont);
        button4.setFocusPainted(false);
        button4.addActionListener(choiceHandler);
        button4.setActionCommand("c4");
        choicePanel.add(button4);

    }

    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid.\n\n" +
                "Guard fought back and hit you hard.\n" +
                "You receive 3 damage)");
        playerDetail.setPlayerHP(-3);
        button1.setText(">");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void crossRoad(){
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\n" +
                "If you to south, you will go back to town");
        button1.setText("Go north");
        button2.setText("Go east");
        button3.setText("Go south");
        button4.setText("Go west");

        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
    }

    public void north(){
        position = "north";
        mainTextArea.setText("There is a river.\n" +
                "You drink the water and rest at the riverside.");
        if (playerDetail.playerHP < 19) {
            mainTextArea.append("\n\n(Your HP is recovered by 2)");
        }
        playerDetail.setPlayerHP(2);
        button1.setText("Go South");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void east(){
        position = "east";
        mainTextArea.setText("You walked into the forest");

        if (playerDetail.weapon.equals("Knife")){
            mainTextArea.append(" and found a Long Sword!");
            playerDetail.setWeapon("Long Sword");
            mainTextArea.append("\n\n(You obtain a Long Sword)");
        } else {
            mainTextArea.append(".");
        }
        button1.setText("Go west");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void west(){
        position = "west";
        if (playerDetail.monsterHP > 0){
            mainTextArea.setText("You encounter a goblin!");
            button1.setText("Fight");
            button2.setText("Run");
            button2.setVisible(true);
        } else {
            mainTextArea.setText("You walked into the forest.");
            button1.setText(">");
            button2.setText("");
            button2.setVisible(false);
        }
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void fight(){
        position = "fight";
        mainTextArea.setText("Monster HP: " + playerDetail.monsterHP);
        mainTextArea.append("\n\nWhat do you do?");
        button1.setText("Attack");
        button2.setText("Run");
        button3.setText("");
        button4.setText("");
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void playerAttack(){
        position = "playerAttack";
        int playerDamage = 0;
        if (playerDetail.weapon.equals("Knife")){
            playerDamage = (int) (Math.random()*4);
        } else if (playerDetail.weapon.equals("Long Sword")){
            playerDamage = (int) (Math.random()*8);
        }
        mainTextArea.setText("You attacked the monster and give " + playerDamage + " damage!");
        playerDetail.setMonsterHP(-playerDamage);

        button1.setText(">");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void monsterAttack(){
        position = "monsterAttack";
        int monsterDamage = (int) (Math.random()*5);

        mainTextArea.setText("Monster attack you and give "  + monsterDamage + " damage!");
        playerDetail.setPlayerHP(-monsterDamage);

        button1.setText(">");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void win(){
        position = "win";
        mainTextArea.setText("You killed the monster!\nThe monster drop the ring!\n\n(You obtain a Silver Ring)");
        playerDetail.silverRing = true;

        button1.setText("Go east");
        button2.setText("");
        button3.setText("");
        button4.setText("");

        button1.setVisible(true);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void lose(){
        position ="lose";
        mainTextArea.setText("You are Dead!\n\n<GAME OVER>");

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }

    public void ending(){
        position = "ending";
        mainTextArea.setText("Guard: Oh you killed that goblin!!\n" +
                "Thank you so much. you are a true hero!" +
                "\nWelcome to our town!\n\n<THE END>");

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
    }




    public class TitleScreenHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }

    public class choiceHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();

            switch (position){
                case "townGate" :
                    switch (choice){
                        case "c1" : if(playerDetail.silverRing) {
                            ending();
                        } else {
                            talkToGuard();
                        } break;
                        case "c2" : attackGuard(); break;
                        case "c3" : crossRoad(); break;
                    }
                    break;
                case "talkToGuard", "attackGuard":
                    switch (choice) {
                        case "c1" : if(playerDetail.playerHP < 1) {
                            lose();
                        } else{
                            townGate();
                        }
                    }
                    break;
                case "crossRoad" :
                    switch (choice) {
                        case "c1" : north(); break;
                        case "c2" : east(); break;
                        case "c3" : townGate(); break;
                        case "c4" : west(); break;
                    }
                    break;
                case "north", "east", "win":
                    switch (choice) {
                        case "c1" : crossRoad();
                    }
                    break;
                case "west" :
                    switch (choice) {
                        case "c1" : if (playerDetail.monsterHP < 1){
                            crossRoad();
                        } else {
                            fight(); break;
                        }
                        case "c2" : crossRoad(); break;
                    }
                    break;
                case "fight" :
                    switch (choice) {
                        case "c1" : playerAttack(); break;
                        case "c2" : crossRoad();
                    }
                    break;
                case "playerAttack" :
                    switch (choice) {
                        case "c1" : if (playerDetail.monsterHP < 1){
                            win();
                        }else{
                            monsterAttack();
                        }
                    }
                break;
                case "monsterAttack" :
                    switch (choice) {
                        case "c1" : if (playerDetail.playerHP < 1) {
                            lose();
                        } else{
                            fight();
                        }
                    }
                    break;
            }
        }
    }
}
