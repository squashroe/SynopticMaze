package game.rooms;

import game.configurations.Settings;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RoomDesigner {

    private Canvas canvas = new Canvas(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
    private GraphicsContext gc;

    public RoomDesigner() {
        gc = canvas.getGraphicsContext2D();


    }


    public Pane createRoom(Room room){
        Pane root = new Pane();
        root.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        Rectangle bg = new Rectangle(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        bg.setFill(Color.SADDLEBROWN);


        //adds the background and doors to the pane
        root.getChildren().addAll(bg, createDoors());
        return root;
    }

    public Pane createDoors() {
        Pane doorLayer = new Pane();
        Rectangle doorNorth = new Rectangle(40, 20);
        doorNorth.relocate(Settings.SCENE_WIDTH /2, 0);

        Rectangle doorEast = new Rectangle(20, 40);
        doorEast.relocate(Settings.SCENE_WIDTH - 20, Settings.SCENE_HEIGHT/2 -40);

        Rectangle doorSouth = new Rectangle(40, 25);
        doorSouth.relocate(Settings.SCENE_WIDTH /2 - 40, Settings.SCENE_HEIGHT - 20);

        Rectangle doorWest = new Rectangle(20, 40);
        doorWest.relocate(0, Settings.SCENE_HEIGHT / 2);



        doorLayer.getChildren().addAll(doorNorth,doorEast,doorSouth,doorWest);

        return doorLayer;
    }

}
