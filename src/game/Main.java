package game;

import game.configurations.Settings;
import game.menus.MainMenuController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends Application {

    private ScheduledExecutorService bgThread = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void start(Stage primaryStage){

        Group root = new Group();
        MainMenuController mainMenuController = new MainMenuController();

        root.getChildren().add(mainMenuController.createContent());

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
