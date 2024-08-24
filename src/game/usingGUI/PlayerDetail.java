package game.usingGUI;

import javax.swing.*;
import java.awt.*;

public class PlayerDetail {

    int monsterHP;
    int playerHP;
    String weapon;
    boolean silverRing;

    JPanel playerPanel;
    JLabel hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font boldFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font italiclFont = new Font("Times New Roman", Font.ITALIC, 28);

    public PlayerDetail(){
        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        playerPanel.setVisible(true);

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

        playerSetUp();
    }

    public void playerSetUp(){
        monsterHP = 20;
        playerHP = 15;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText(Integer.toString(playerHP));
    }

    public void setPlayerHP(int damage) {
        if (playerHP < 19 || damage < 0) {
            playerHP += damage;
        } else if (playerHP == 19) {
            playerHP += 1;
        }
        hpLabelNumber.setText(Integer.toString(playerHP));
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
        weaponLabelName.setText(weapon);
    }

    public void setMonsterHP(int damage) {
        this.monsterHP += damage;
    }
}
