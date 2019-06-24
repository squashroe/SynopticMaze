package game.rooms;

import game.configurations.Settings;
import game.items.Threat;
import game.items.Treasure;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoomDesigner {

    private Canvas canvas = new Canvas(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
    private GraphicsContext gc;
    private boolean thisRoomVisited;

    public RoomDesigner() {
        gc = canvas.getGraphicsContext2D();
    }


    public Pane createRoomPane(int roomId) {
        Settings.CURRENT_ROOM_ID = roomId;
        System.out.println("Current roomId : " + roomId);
        Pane root = new Pane();
        root.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        Rectangle bg = new Rectangle(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        if ((roomId % 2) == 0) {
            bg.setFill(Color.SADDLEBROWN);
        }
        if ((roomId % 2) != 0) {
            bg.setFill(Color.WHITE);
        }
        if (roomId == 9) {
            bg.setFill(Color.RED);
            root.getChildren().addAll(bg, createDoors(), Settings.getPLAYER().getPlayerImage());
            // say well done you completed hte game
            return root;
        }
        //System.out.println("room: "+roomId+"visited = "+Settings.ROOM_LIST.get(Settings.CURRENT_ROOM_ID).isVisited());
        //TODO: add detail to floor

        //add treasure
        Pane treasureLayer = createTreasureLayer(roomId);
        //add threats
        Pane threatLayer = createThreatLayer();

        //check if I've visited a room
        Settings.ROOM_LIST.get(Settings.CURRENT_ROOM_ID).setVisited(true);

        //adds the background, doors, player, treasure and threats to the pane
        root.getChildren().addAll(bg, createDoors(), Settings.getPLAYER().getPlayerImage(),
                treasureLayer, threatLayer);
        Settings.ROOM_LIST.get(Settings.CURRENT_ROOM_ID).setVisited(true);
        return root;
    }


    public Pane createDoors() {
        Pane doorLayer = new Pane();
        Rectangle doorNorth = new Rectangle(40, 20);
        doorNorth.relocate(Settings.SCENE_WIDTH / 2 - 20, 0);
        //TODO: colour doors

        Rectangle doorEast = new Rectangle(20, 40);
        doorEast.relocate(Settings.SCENE_WIDTH - 20, Settings.SCENE_HEIGHT / 2 - 20);

        Rectangle doorSouth = new Rectangle(40, 25);
        doorSouth.relocate(Settings.SCENE_WIDTH / 2 - 20, Settings.SCENE_HEIGHT - 20);

        Rectangle doorWest = new Rectangle(20, 40);
        doorWest.relocate(0, Settings.SCENE_HEIGHT / 2 - 20);

        doorLayer.getChildren().addAll(doorNorth, doorEast, doorSouth, doorWest);

        return doorLayer;
    }

    public Pane createTreasureLayer(int roomId) {
        Pane treasureLayer = new Pane();

        // if i have visited the room before, save the coins that had spawned originally
        if(Settings.ROOM_LIST.get(Settings.CURRENT_ROOM_ID).isVisited()){
            return Settings.roomTreasurePaneList.get(roomId);
        }

        Random rand = new Random();
        //add treasure
        int amountInRoom = rand.nextInt(Settings.MAX_TREASURE_PER_ROOM);
        List<Treasure> treasuresInRoom = new ArrayList<>();
        for (int i = 0; i < amountInRoom; i++) {
            Treasure treasure = new Treasure(i, (rand.nextInt((int) Settings.SCENE_WIDTH - 120)) +80,
                    (rand.nextInt((int) Settings.SCENE_HEIGHT - 120))+ 80, rand.nextInt(3));
            treasuresInRoom.add(treasure);
            treasureLayer.getChildren().add(treasure.getImage());
        }
        Settings.treasuresInCurrentRoom = treasuresInRoom;
        Settings.roomTreasurePaneList.put(roomId, treasureLayer);
        return treasureLayer;
    }

    private Pane createThreatLayer() {
        Pane threatLayer = new Pane();
        Random rand = new Random();
        //add threats
        int amountInRoom = rand.nextInt(Settings.MAX_THREATS_PER_ROOM);

        for (int i = 0; i < amountInRoom; i++) {
            Threat threat = new Threat(i, rand.nextInt((int) Settings.SCENE_WIDTH - 80),
                    rand.nextInt((int) Settings.SCENE_HEIGHT - 80), rand.nextInt(3));
            threatLayer.getChildren().add(threat.getImage());
        }
        return threatLayer;
    }

}
