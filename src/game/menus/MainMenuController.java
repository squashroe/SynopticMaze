package game.menus;

import game.configurations.Settings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MainMenuController {

    private VBox menuBox;

    public MainMenuController() {
    }

    public Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        Rectangle bg = new Rectangle(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        HBox hbox = new HBox(createTitle());
        hbox.setTranslateX(120);
        hbox.setTranslateY(50);

        MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnActivate(() -> System.exit(0));

        menuBox = new VBox(10,
                new MenuItem("PLAY GAME"),
                new MenuItem("OPTIONS"),
                itemExit);
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(360);
        menuBox.setTranslateY(300);

        Text about = new Text("Made by Olde Worlde Phunne");
        about.setTranslateX(50);
        about.setTranslateY(500);
        about.setFill(Color.WHITE);
        about.setFont(Settings.FONT);
        about.setOpacity(0.2);

        getMenuItem(0).setActive(true);

        root.getChildren().addAll(bg, hbox, menuBox, about);
        return root;
    }

    private Node createTitle() {
        Text title = new Text("Maze Game");
        HBox letters = new HBox(title);
        letters.setAlignment(Pos.CENTER);
        return letters;
    }

    private MenuItem getMenuItem(int index) {
        return (MenuItem) menuBox.getChildren().get(index);
    }

    public VBox getMenuBox() {
        return menuBox;
    }
}
