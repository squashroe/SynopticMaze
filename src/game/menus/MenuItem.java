package game.menus;

import game.configurations.Settings;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * class that generates items within the list of options in main menu
 */
public class MenuItem extends HBox {
    private Text text;
    private Runnable script;

    MenuItem(String name) {
        super(15);
        setAlignment(Pos.CENTER);

        text = new Text(name);
        text.setFont(Settings.FONT);

        getChildren().addAll(text);
        setActive(false);
        setOnActivate(() -> System.out.println(name + " activated"));
    }

    public void setActive(boolean b) {
        text.setFill(b ? Color.WHITE : Color.GREY);
    }

    void setOnActivate(Runnable r) {
        script = r;
    }

    public void activate() {
        if (script != null)
            script.run();
    }
}