package game.ImproveUsingGUI;

import javax.swing.*;
import java.awt.*;

public class UI {
    Container container;

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choicePanel;
    JLabel titleNameLabel;
    JTextArea mainTextArea;
    JButton button1, button2, button3, button4;
    Font titleNameFont = new Font("Times New Roman",Font.BOLD,90);
    JButton startButton;
    Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 27);

    // PLAYER ATTRIBUTE
    JPanel playerPanel;
    JLabel hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font boldFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font italiclFont = new Font("Times New Roman", Font.ITALIC, 28);

    public void createUI(Game.ChoiceHandler cHandler){

        // WINDOW
        window = new JFrame("ADVENTURE GAME");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();


        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleNameFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(startButtonFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        container.add(titleNamePanel);
        container.add(startButtonPanel);


        // GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("This is main area");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);


        // CHOICE OPTION
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
        button1.addActionListener(cHandler);
        button1.setActionCommand("c1");
        choicePanel.add(button1);

        button2 =new JButton("Choice 2");
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.setFont(normalFont);
        button2.setFocusPainted(false);
        button2.addActionListener(cHandler);
        button2.setActionCommand("c2");
        choicePanel.add(button2);

        button3 =new JButton("Choice 3");
        button3.setBackground(Color.black);
        button3.setForeground(Color.white);
        button3.setFont(normalFont);
        button3.setFocusPainted(false);
        button3.addActionListener(cHandler);
        button3.setActionCommand("c3");
        choicePanel.add(button3);

        button4 =new JButton("Choice 4");
        button4.setBackground(Color.black);
        button4.setForeground(Color.white);
        button4.setFont(normalFont);
        button4.setFocusPainted(false);
        button4.addActionListener(cHandler);
        button4.setActionCommand("c4");
        choicePanel.add(button4);


        // PLAYER PANEL
        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        container.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setForeground(Color.white);
        hpLabel.setFont(boldFont);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setForeground(Color.yellow);
        hpLabelNumber.setFont(italiclFont);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("WEAPON:");
        weaponLabel.setFont(boldFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setForeground(Color.yellow);
        weaponLabelName.setFont(italiclFont);
        playerPanel.add(weaponLabelName);
    }
}
