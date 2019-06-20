package game;

import game.configurations.Settings;
import game.engine.MazeCreator;
import game.menus.MainMenuController;
import game.rooms.Room;
import game.rooms.RoomDesigner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends Application {

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();
    RoomDesigner roomDesigner = new RoomDesigner();
    @Override
    public void start(Stage primaryStage){

        Group root = new Group();
        MainMenuController mainMenuController = new MainMenuController();
        MazeCreator mazeCreator = new MazeCreator();

        Room room1 = mazeCreator.roomCreator(1, false, null, true, 2,
                true, 6, true, 5);

        root.getChildren().add(roomDesigner.createRoom(room1));
        mainMenuController.createContent();
        Scene menuScene = new Scene(root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        primaryStage.setScene(menuScene);
        primaryStage.setOnCloseRequest(event -> {
            bgThread.shutdownNow();
        });
        //MenuInputListener menuInputListener = new MenuInputListener(menuScene);
//        menuInputListener.addListener();
        primaryStage.show();

//
    }


    public static void main(String[] args) {
        launch(args);
    }
}
