package game.ImproveUsingGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    UI ui = new UI();
    ChoiceHandler cHandler = new ChoiceHandler();
    VisibilityManager vManger = new VisibilityManager(ui);
    Story story = new Story(this, ui, vManger);

    String position1, position2, position3, position4;

    public static void main(String[] args) {
        new Game();
    }

    Game(){
        ui.createUI(cHandler);
        story.defaultSetUp();
        vManger.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (yourChoice){
                case "start" : vManger.showMainScreen(); story.townGate(); break;
                case "c1" : story.selectPosition(position1); break;
                case "c2" : story.selectPosition(position2); break;
                case "c3" : story.selectPosition(position3); break;
                case "c4" : story.selectPosition(position4); break;
            }
        }
    }
}
