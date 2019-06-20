package game;

import game.configurations.Settings;
import game.engine.GameInput;
import game.engine.MazeCreator;
import game.menus.MainMenuController;
import game.player.Player;
import game.rooms.Room;
import game.rooms.RoomDesigner;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends Application {

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();
    RoomDesigner roomDesigner = new RoomDesigner();
    @Override
    public void start(Stage primaryStage){
        Group gameRoot = new Group();
        Group menuRoot = new Group();
        MainMenuController mainMenuController = new MainMenuController();
        MazeCreator mazeCreator = new MazeCreator();

        //make the game and player field
        gameRoot.getChildren().addAll(mazeCreator.createStartingRoom(), mazeCreator.createPlayer());
//
        Scene menuScene = new Scene(menuRoot, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        Scene gameScene = new Scene(gameRoot, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        GameInput gameInput = new GameInput(gameScene);
        gameInput.addListeners();

        primaryStage.setScene(gameScene);
        primaryStage.setOnCloseRequest(event -> {
            bgThread.shutdownNow();
        });
        //MenuInputListener menuInputListener = new MenuInputListener(menuScene);
//        menuInputListener.addListener();
        primaryStage.show();

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {

                //player Input
                Settings.getPLAYER().move();

            }
        };
        gameLoop.start();

//
    }


    public static void main(String[] args) {
        launch(args);
    }
}
