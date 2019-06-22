package game;

import game.configurations.Settings;
import game.engine.GameInput;
import game.engine.MazeCreator;
import game.menus.MainMenuController;
import game.rooms.RoomDesigner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends Application {

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();
    RoomDesigner roomDesigner = new RoomDesigner();

    @Override
    public void start(Stage primaryStage) {
        Settings.GAMEROOT = new Group();
        Group menuRoot = new Group();
        MainMenuController mainMenuController = new MainMenuController();
        Scene menuScene = new Scene(menuRoot, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        //create the game scene
        MazeCreator mazeCreator = new MazeCreator();
        mazeCreator.createGameScene();

        //set up listener for input from user on game scene
        GameInput gameInput = new GameInput(Settings.GAMESCENE);
        gameInput.addListeners();


        //put the scene on the stage
        primaryStage.setScene(Settings.GAMESCENE);
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
