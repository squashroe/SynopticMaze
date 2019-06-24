package game.engine;

import game.configurations.Settings;
import game.items.Treasure;
import game.rooms.Door;
import game.rooms.Passage;
import game.rooms.Room;
import game.rooms.RoomDesigner;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeCreator {

    static boolean changeDoorTrigger = false;
    static boolean checkDoor = true;
    private static boolean changedRoom;

    public MazeCreator() {
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
                collisionsWithTreasure();

            }
        };
        gameLoop.start();
    }

    public void createGameScene() {
        //make the game and player field
        Settings.GAME_PANE = createStartingRoom();
        Group gameRoot = new Group();
        Settings.GAMEROOT.getChildren().addAll(Settings.GAME_PANE, Settings.getPLAYER().getPlayerImage());

        //create the Scene with the game related stuff
        Settings.GAMESCENE = new Scene(Settings.GAMEROOT, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);

        //set up listener for input from user on game scene
        GameInput gameInput = new GameInput(Settings.GAMESCENE);
        gameInput.addListeners();
    }

    private Pane createStartingRoom() {
        Random rand = new Random();
        RoomDesigner roomDesigner = new RoomDesigner();
        int randomRoomId = rand.nextInt(Settings.ROOM_LIST.size() - 1) + 1;
        // set the current room ID for future look up
        return roomDesigner.createRoomPane(randomRoomId);
        // - 1 because we don't want to start in room 8 as that's the finish
        //and +1 so we don't have 0

    }

    private static void collisionsWithTreasure() {
        List<Treasure> toRemove = new ArrayList();
        for (Treasure treasure : Settings.treasuresInCurrentRoom) {
            if (Settings.getPLAYER().collidesWith(treasure)) {
                Settings.getPLAYER().collectTreasure(treasure);
                treasure.getImage().relocate(9999, 9999);//cheap way to get rid of treasure
                toRemove.add(treasure);
            }
        }
        Settings.treasuresInCurrentRoom.removeAll(toRemove);
    }

    /**
     * checks if the player is going through any of the doors
     */
    private static void isPlayerCollidingWithDoor() {
        boolean collideNorthDoor = comparePlayerCoordinates((Settings.SCENE_WIDTH / 2), 0.0);
        boolean collideEastDoor = comparePlayerCoordinates(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT / 2);
        boolean collideSouthDoor = comparePlayerCoordinates(Settings.SCENE_WIDTH / 2, Settings.SCENE_HEIGHT);
        boolean collideWestDoor = comparePlayerCoordinates(0.0, Settings.SCENE_HEIGHT / 2);
        if (collideNorthDoor || collideEastDoor || collideSouthDoor || collideWestDoor) {
            checkDoor = true; // this makes the check door stop giving a null pointer when it runs again after
            // moving the player
            changeDoorTrigger = true;
            Settings.CHANGE_ROOM_COUNTER++;
        }

        //added an equals 1 condition that counts so that the method only runs once.
        if (Settings.CHANGE_ROOM_COUNTER == 1 && checkDoor && Settings.doorsUnlocked) {
            changePaneThroughPassage();
        }
        if (!changeDoorTrigger) {
            Settings.CHANGE_ROOM_COUNTER = 0;
        }
        changeDoorTrigger = false;
    }

    /**
     * changes the Pane so that the room changes
     *
     * @return
     */
    private static void changePaneThroughPassage() {

        Door door = getDoorFromRoom();

        Passage passage = Settings.PASSAGE_LIST.get(door.getPassageId());

        if (passage.getId() == 99) {
            //TODO : print message to screen
            System.out.println("You cannot go this way.");
        }
        //Room I am currently in
        int currentRoomId = door.getParentRoomId();

        int newDoorToSpawnAt = 0;
        changedRoom = false;
        RoomDesigner roomDesigner = new RoomDesigner();

        //if the room i am in is the same as the "room from" in passage, go to "room to" in passage
        if (currentRoomId == passage.getFromRoomId()) {
            changedRoom = true;
            newDoorToSpawnAt = passage.getToDoorId();
            Settings.getPLAYER().spawnInRoom(newDoorToSpawnAt);
            Settings.GAME_PANE = roomDesigner.createRoomPane(passage.getToRoomId());
        }
        //if the room i am in is the "room to" in passage, then go to "room from" in passage
        if (currentRoomId == passage.getToRoomId()) {
            changedRoom = true;
            newDoorToSpawnAt = passage.getFromDoorId();
            Settings.getPLAYER().spawnInRoom(newDoorToSpawnAt);
            Settings.GAME_PANE = roomDesigner.createRoomPane(passage.getFromRoomId());
        }

        if (passage.isExit() || Settings.GAME_COMPLETE) {
            Settings.GAME_COMPLETE = true;
            Settings.GAME_PANE.getChildren().add(createCompleteGamePane());
        }

        if (changedRoom) {
            Settings.GAMEROOT.getChildren().addAll(Settings.GAME_PANE);
        }
        checkDoor = false;
    }


    private static Door getDoorFromRoom() {
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
        return null;
    }

    private static boolean comparePlayerCoordinates(Double mapX, Double mapY) {
        boolean collidedWithDoor = false;
        boolean collideWithDoorX = (Settings.getPLAYER().getX() >= mapX - 40) && (Settings.getPLAYER().getX() <= mapX + 40);
        boolean collideWithDoorY = (Settings.getPLAYER().getY() >= mapY - 40) && (Settings.getPLAYER().getY() <= mapY + 40);

        //System.out.println("PX" +Settings.getPLAYER().getX()+ "MX" +mapX + collideWithDoorX);
        if (collideWithDoorX && collideWithDoorY) {
            collidedWithDoor = true;
        }

        return collidedWithDoor;
    }


    private static Pane createCompleteGamePane() {
        Pane completeGamePane = new Pane();
        Text completeGameMessage = new Text();
        completeGameMessage.setFont(Font.font(null, FontWeight.BOLD, 54));
        completeGameMessage.setStroke(Color.BLACK);
        completeGameMessage.setFill(Color.YELLOW);
        completeGameMessage.relocate(100, 100);
        completeGameMessage.setText("Congratulations \n" + Settings.PLAYER_NAME);
        completeGameMessage.setBoundsType(TextBoundsType.VISUAL);
        //add in score
        Text scoreMessage = new Text();
        scoreMessage.setFont(Font.font(null, FontWeight.BOLD, 44));
        scoreMessage.setStroke(Color.BLACK);
        scoreMessage.setFill(Color.BLACK);
        scoreMessage.relocate(100, 300);
        scoreMessage.setText("Total Wealth: " + Settings.TOTAL_WEALTH);
        scoreMessage.setBoundsType(TextBoundsType.VISUAL);

        //add in instructions to quit and start again?!
        Text returnToMenuMessage = new Text();
        returnToMenuMessage.setFont(Settings.FONT);
        returnToMenuMessage.setStroke(Color.BLACK);
        returnToMenuMessage.setFill(Color.BLACK);
        returnToMenuMessage.relocate(100, 500);
        returnToMenuMessage.setText("Return to menu to create new maze");
        returnToMenuMessage.setBoundsType(TextBoundsType.VISUAL);

        completeGamePane.getChildren().addAll(completeGameMessage, scoreMessage, returnToMenuMessage);
        return completeGamePane;
    }

}
