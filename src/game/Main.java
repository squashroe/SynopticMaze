package game;

import game.configurations.ConfigTranslator;
import game.configurations.Settings;
import game.engine.MazeCreator;
import game.menus.MainMenuController;
import game.menus.ScreenController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * CREATED BY JOSHUA ROE - 24/06/2019
 */

public class Main extends Application {

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();
    private int currentItem = 0;

    @Override
    public void start(Stage primaryStage) {
        ConfigTranslator.readFile();
        Settings.GAMEROOT = new Group();

        //create the game scene
        MazeCreator mazeCreator = new MazeCreator();
        mazeCreator.createGameScene();

        //Make the main menu
        MainMenuController mainMenuController = new MainMenuController();
        Pane mainMenu = mainMenuController.createContent();
        Settings.MENUSCENE = new Scene(mainMenu);

        ScreenController screenController = new ScreenController(Settings.MENUSCENE);
        screenController.addScreen(0, Settings.GAME_PANE);
        screenController.addScreen(1, new Pane()); //insert Panes
        screenController.addScreen(2, new Pane());

        Settings.MENUSCENE.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (currentItem > 0) {
                    mainMenuController.getMenuItem(currentItem).setActive(false);
                    mainMenuController.getMenuItem(--currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.DOWN) {
                if (currentItem < mainMenuController.getMenuBox().getChildren().size() - 1) {
                    mainMenuController.getMenuItem(currentItem).setActive(false);
                    mainMenuController.getMenuItem(++currentItem).setActive(true);
                }
            }

            if (event.getCode() == KeyCode.ENTER) {
                mainMenuController.getMenuItem(currentItem).activate();
                screenController.activate(currentItem, primaryStage);
            }
        });

        //put the scene on the stage
        primaryStage.setScene(Settings.MENUSCENE);
        primaryStage.setOnCloseRequest(event -> {
            bgThread.shutdownNow();
        });

        MazeCreator.runAnimation();

        //display the stage to the window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
