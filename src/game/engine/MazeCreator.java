package game.engine;

import game.configurations.Settings;
import game.player.Player;
import game.rooms.Door;
import game.rooms.Passage;
import game.rooms.RoomDesigner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class MazeCreator {

    public MazeCreator() {
    }
    //here you can create the rooms
    //from that you can then call the doors from the rooms
    //from that you can then call the passages from the doors
    //then pass down the room ID for the passage to know where to send you based on which door you entered.


    public Pane createStartingRoom() {
        Random rand = new Random();
        RoomDesigner roomDesigner = new RoomDesigner();
        int randomRoomId = rand.nextInt(Settings.ROOM_LIST.size()- 1) + 1;
        return roomDesigner.createRoomPane(randomRoomId);
        // - 1 because we don't want to start in room 8 as that's the finish
        //and +1 so we don't have 0
    }

    public Pane createPlayer() {
        Pane playFieldLayer = new Pane();
        Player player = Settings.getPLAYER();
        playFieldLayer.getChildren().add(player.getPlayerImage());
        return playFieldLayer;
    }

    public Pane changePaneThroughPassage(Door door) {
        Passage passage = Settings.PASSAGE_LIST.get(door.getPassageId());

        //Room I am currently in
        int currentRoomId = door.getParentRoomId();

        RoomDesigner roomDesigner = new RoomDesigner();
        Pane newRoomPane = roomDesigner.createRoomPane(currentRoomId);

        //if the room i am in is the same as the "room from" in passage, go to "room to" in passage
        if(currentRoomId == passage.getFromRoomId()){
             newRoomPane = roomDesigner.createRoomPane(passage.getToRoomId());
        }
        //if the room i am in is the "room to" in passage, then go to "room from" in passage
        else if (currentRoomId == passage.getToRoomId()) {
            newRoomPane = roomDesigner.createRoomPane(passage.getFromRoomId());
        }
        System.out.println("room IDs don't match");

        //add player

        //add treasure

        //add threats

        //addAll to the Pane

        return newRoomPane;
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
