package game.ImproveUsingGUI;

public class VisibilityManager {

    UI ui;

    VisibilityManager(UI ui){
        this.ui = ui;
    }

    void showTitleScreen (){
        // SHOW TITLE SCREEN
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // HIDE GAME SCREEN
        ui.mainTextPanel.setVisible(false);
        ui.choicePanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    void showMainScreen (){
        // HIDE TITLE SCREEN
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Show GAME SCREEN
        ui.mainTextPanel.setVisible(true);
        ui.choicePanel.setVisible(true);
        ui.playerPanel.setVisible(true);

    }
}
