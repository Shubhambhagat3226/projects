package practice.frame;

import javax.swing.*;

public class MyFrameExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First JFrame");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
