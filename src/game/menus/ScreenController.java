package game.menus;

import game.Main;
import game.configurations.Settings;
import game.engine.MazeCreator;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

public class ScreenController {
    private HashMap<Integer, Pane> screenMap = new HashMap<>();

    public ScreenController(Scene main) {
    }

    public void addScreen(Integer menuPlace, Pane pane) {
        screenMap.put(menuPlace, pane);
    }

    public void removeScreen(Integer menuPlace) {
        screenMap.remove(menuPlace);
    }

    private static Stage primaryStage;

    /**
     * switches the scene on the display
     * @param menuPlace which menu item you are selecting
     * @param primaryStage main stage of the project
     */
    public void activate(Integer menuPlace, Stage primaryStage) {
        this.primaryStage = primaryStage;
        if (menuPlace == 0) {
            primaryStage.setScene(Settings.GAMESCENE);
        }
        //This will restart the app so the user can play again with the default settings.
        if (menuPlace == 1){
            primaryStage.close();
            Platform.runLater( () -> {
                new Main().start(new Stage());
            });
            primaryStage.setScene(Settings.GAMESCENE);
        }
    }

    public static void backToMenu() {
        primaryStage.setScene(Settings.MENUSCENE);
    }
}
