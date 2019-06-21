package game.engine;

import game.configurations.Settings;
import game.player.Player;
import game.rooms.Door;
import game.rooms.Passage;
import game.rooms.Room;
import game.rooms.RoomDesigner;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.Random;

import static game.configurations.Settings.GAME_PANE;

public class MazeCreator {

    static boolean changeDoorTrigger = false;

    public MazeCreator() {
    }
    //here you can create the rooms
    //from that you can then call the doors from the rooms
    //from that you can then call the passages from the doors
    //then pass down the room ID for the passage to know where to send you based on which door you entered.

    public void createGameScene() {
        //make the game and player field
        Settings.GAME_PANE = createStartingRoom();
        Settings.GAMEROOT.getChildren().addAll(Settings.GAME_PANE, createPlayer());

        //create the Scene with the game related stuff
        Settings.GAMESCENE = new Scene(Settings.GAMEROOT, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
    }

    public Pane createStartingRoom() {
        Random rand = new Random();
        RoomDesigner roomDesigner = new RoomDesigner();
        int randomRoomId = rand.nextInt(Settings.ROOM_LIST.size() - 1) + 1;
        // set the current room ID for future look up
        return roomDesigner.createRoomPane(randomRoomId);
        // - 1 because we don't want to start in room 8 as that's the finish
        //and +1 so we don't have 0

    }


    public static Pane createPlayer() {
        Pane playFieldLayer = new Pane();
        Player player = Settings.getPLAYER();
        playFieldLayer.getChildren().add(player.getPlayerImage());
        return playFieldLayer;
    }

    /**
     * Animates the Screen
     */
    public static void runAnimation() {
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //player Input
                Settings.getPLAYER().move();
                isPlayerCollidingWithDoor();
            }
        };
        gameLoop.start();
    }

    /**
     *checks if the player is going through any of the doors
     */
    public static void isPlayerCollidingWithDoor() {
        boolean collideNorthDoor = comparePlayerCoordinates((Settings.SCENE_WIDTH / 2), 0.0);
        boolean collideEastDoor = comparePlayerCoordinates(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT / 2);
        boolean collideSouthDoor = comparePlayerCoordinates(Settings.SCENE_WIDTH / 2, Settings.SCENE_HEIGHT);
        boolean collideWestDoor = comparePlayerCoordinates(0.0, Settings.SCENE_HEIGHT / 2);
        if (collideNorthDoor|| collideEastDoor || collideSouthDoor || collideWestDoor ){
            changeDoorTrigger = true;
            Settings.CHANGE_ROOM_COUNTER++;
        }

        if(Settings.CHANGE_ROOM_COUNTER == 1){
            changePaneThroughPassage();
            System.out.println("hello");
        }
        if(!changeDoorTrigger){
            Settings.CHANGE_ROOM_COUNTER = 0;
        }
        changeDoorTrigger = false;

    }

    /**
     * changes the Pane so that the room changes
     * @return
     */
    public static void changePaneThroughPassage() {

        Door door = getDoorFromRoom();

        Passage passage = Settings.PASSAGE_LIST.get(door.getPassageId());

        if (passage.getId() == 99){
            System.out.println("You cannot go this way.");
        }
        //Room I am currently in
        int currentRoomId = door.getParentRoomId();

        RoomDesigner roomDesigner = new RoomDesigner();
        Pane newRoomPane = roomDesigner.createRoomPane(currentRoomId);

        //if the room i am in is the same as the "room from" in passage, go to "room to" in passage
        if (currentRoomId == passage.getFromRoomId()) {
            newRoomPane = roomDesigner.createRoomPane(passage.getToRoomId());
        }
        //if the room i am in is the "room to" in passage, then go to "room from" in passage
        if (currentRoomId == passage.getToRoomId()) {
            newRoomPane = roomDesigner.createRoomPane(passage.getFromRoomId());
        }

        //add player
        newRoomPane.getChildren().add(Settings.getPLAYER().getPlayerImage());
        //add treasure

        //add threats

        //addAll to the Pane

        Settings.GAME_PANE  =  newRoomPane;
        Settings.GAMEROOT.getChildren().addAll(Settings.GAME_PANE, createPlayer());
    }

    public static Door getDoorFromRoom() {
        //detect which room / door I am at
        //get the door and pass it into changePaneThroughPassage()
        //store THAT as a Pane and pass it back to the
        Room room = Settings.ROOM_LIST.get(Settings.CURRENT_ROOM_ID);

        if (comparePlayerCoordinates(Settings.SCENE_WIDTH / 2, 0.0)) {
            return room.getDoorNorth();
        }
        if (comparePlayerCoordinates(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT / 2)) {
            return room.getDoorEast();
        }
        if (comparePlayerCoordinates(Settings.SCENE_WIDTH / 2, Settings.SCENE_HEIGHT)) {
            return room.getDoorSouth();
        }
        if (comparePlayerCoordinates(0.0, Settings.SCENE_HEIGHT / 2)) {
            return room.getDoorWest();
        }
        return null; // always want a door to be passed back
    }

    private static boolean comparePlayerCoordinates(Double mapX, Double mapY) {
        boolean collidedWithDoor = false;
        boolean collideWithDoorX = (Settings.getPLAYER().getX() >= mapX - 40) && (Settings.getPLAYER().getX() <= mapX + 40);
        boolean collideWithDoorY = (Settings.getPLAYER().getY() >= mapY -40) && (Settings.getPLAYER().getY() <= mapY + 40);

        //System.out.println("PX" +Settings.getPLAYER().getX()+ "MX" +mapX + collideWithDoorX);
        if (collideWithDoorX && collideWithDoorY) {
            collidedWithDoor = true;
        }

        return collidedWithDoor;
    }


    public int setAmountOfTreasure() {
        //TODO : get amount of treasure per room from config
        return -1;
    }

    public int setAmountOfThreats() {
        //TODO : get amount of threats per room from config
        return -1;
    }

//    public void onCompleteGame() {
//        if(isExit == true)
//    }


}
