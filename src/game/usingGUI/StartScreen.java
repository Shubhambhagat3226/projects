package game.usingGUI;

import javax.swing.*;
import java.awt.*;

public class StartScreen {
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    Font titleNameFont = new Font("Times New Roman",Font.BOLD,90);
    JButton startButton;
    Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30);


    public StartScreen(){

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleNameFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200,100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(startButtonFont);
        startButton.setFocusPainted(false);

        startButtonPanel.add(startButton);
        titleNamePanel.add(titleNameLabel);
    }
}
