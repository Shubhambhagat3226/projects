package practice.panel;
import java.awt.*;
import javax.swing.*;

public class JPanelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JPanel Example");
        JPanel panel = new JPanel();

        panel.setBackground(Color.CYAN);
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        panel.updateUI();
//        panel.setBackground(Color.black);
//        panel.getUI();
    }
}
