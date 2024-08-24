package practice.jbuton;

import javax.swing.*;

public class button {
    public static void main(String[] args) {
        JFrame frame = new JFrame("button click");
        JPanel panel = new JPanel();
        JButton button = new JButton("Click me");

        panel.add(button);
        frame.add(panel);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
