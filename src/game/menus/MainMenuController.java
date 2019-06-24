package game.menus;

import game.configurations.Settings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class MainMenuController {

    private VBox menuBox;

    public MainMenuController() {
    }

    public Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        Rectangle bg = new Rectangle(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        ContentFrame frame = new ContentFrame(createBoxContent());

        HBox hbox = new HBox(frame);
        hbox.setTranslateX(20);
        hbox.setTranslateY(100);

        MenuItem itemExit = new MenuItem("QUIT GAME");
        itemExit.setOnActivate(() -> System.exit(0));

        menuBox = new VBox(10.0,
                new MenuItem("PLAY GAME"),
                new MenuItem("OPTIONS"),
                itemExit);
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(250);
        menuBox.setTranslateY(400);

        Text about = new Text("Made by \nOlde Worlde Phunne");
        about.setTranslateX(20);
        about.setTranslateY(Settings.SCENE_HEIGHT-50);
        about.setFill(Color.WHITE);
        about.setFont(Settings.FONT);
        about.setOpacity(0.2);


        getMenuItem(0).setActive(true);

        root.getChildren().addAll(bg, hbox, menuBox, about);
        return root;
    }

    public MenuItem getMenuItem(int index) {
        return (MenuItem) menuBox.getChildren().get(index);
    }

    private Node createBoxContent() {
        Text completeGameMessage = new Text();
        completeGameMessage.setFont(Font.font(null, FontWeight.BOLD, 54));
        completeGameMessage.setStroke(Color.BLACK);
        completeGameMessage.setFill(Color.YELLOW);
        completeGameMessage.relocate(0, 100);
        completeGameMessage.setText("MAZE GAME");
        completeGameMessage.setBoundsType(TextBoundsType.VISUAL);
        HBox icon = new HBox(0);
        icon.setAlignment(Pos.CENTER);
        icon.getChildren().add(completeGameMessage);
        return icon;
    }

    public VBox getMenuBox() {
        return menuBox;
    }

    private static class ContentFrame extends StackPane {
        private ContentFrame(Node content) {
            setAlignment(Pos.CENTER_LEFT);

            Rectangle frame = new Rectangle(600, 200);
            frame.setArcWidth(25);
            frame.setArcHeight(25);
            frame.setStroke(Color.WHITESMOKE);

            getChildren().addAll(frame, content);
        }
    }
}
