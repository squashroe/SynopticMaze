package game.configurations;

import game.items.Threat;
import game.items.Treasure;
import game.player.Player;
import game.rooms.Door;
import game.rooms.Passage;
import game.rooms.Room;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Settings {

    //Player Settings
    private static Player PLAYER = new Player(Settings.SCENE_WIDTH /2, Settings.SCENE_HEIGHT /2);
    public static String PLAYER_NAME = "Josh Roe";
    public static int TOTAL_WEALTH;


    //TODO: change the font to something really cool
    public static Font FONT = Font.font("Alegreya Sans SC", FontWeight.BOLD, 18);

    //Game play Settings
    public static double SCENE_WIDTH = 640;
    public static double SCENE_HEIGHT = 640;
    public static Group GAMEROOT;
    public static Scene GAMESCENE;
    public static Scene MENUSCENE;
    public static Pane GAME_PANE;
    public static boolean GAME_COMPLETE = false;
    public static Player getPLAYER() {
        return PLAYER;
    }

    //Treasure Settings
    public static int MAX_TREASURE_PER_ROOM = 5;
    public static List<Treasure> treasuresInCurrentRoom = new ArrayList<>();
    public static HashMap<Integer, Pane> roomTreasurePaneList = new HashMap<>();

    //Threat Settings
    public static int MAX_THREATS_PER_ROOM = 5;
    public static List<Threat> threatsInCurrentRoom = new ArrayList<>();
    public static boolean ESCPRESSED;

    //Room Settings
    public static HashMap<Integer, Room> ROOM_LIST = createAllRooms();
    public static int CURRENT_ROOM_ID = 0;
    public static int CHANGE_ROOM_COUNTER = 0;
    public static boolean doorsUnlocked = true;
    public static HashMap<Integer, Passage> PASSAGE_LIST = createAllPassages();


    private static HashMap<Integer, Room> createAllRooms() {
        HashMap<Integer, Room> tempRoomList = new HashMap<>();
        /*
         * rooms are laid out in a square array
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        Room room1 = roomCreator(1, false, 99, true, 2,
                true, 6, true, 5);
        Room room2 = roomCreator(2, true, 1, true, 3,
                true, 7, true, 2);
        Room room3 = roomCreator(3, true, 4, true, 4,
                true, 8, true, 3);
        Room room4 = roomCreator(4, true, 6, true, 9,
                true, 12, true, 1);
        Room room5 = roomCreator(5, true, 7, true, 10,
                false, 99, true, 11);
        Room room6 = roomCreator(6, true, 8, true, 11,
                false, 99, true, 10);
        Room room7 = roomCreator(7, true, 12, true, 13,
                true, 5, false, 99);
        Room room8 = roomCreator(8, true, 9, true, 14,
                false, 99, true, 13);
        Room room9 = roomCreator(9, false, 99, false, 99,
                false, 99, true, 14);

        tempRoomList.put(1, room1);
        tempRoomList.put(2, room2);
        tempRoomList.put(3, room3);
        tempRoomList.put(4, room4);
        tempRoomList.put(5, room5);
        tempRoomList.put(6, room6);
        tempRoomList.put(7, room7);
        tempRoomList.put(8, room8);
        tempRoomList.put(9, room9);

        return tempRoomList;
    }

    private static HashMap<Integer, Passage> createAllPassages() {
        HashMap<Integer, Passage> tempPassageList = new HashMap<>();
        Passage passage1 = new Passage(1, 2, 0, 4, 3);
        Passage passage2 = new Passage(2, 2, 3, 1, 1);
        Passage passage3 = new Passage(3, 2, 1, 3, 3);
        Passage passage4 = new Passage(4, 3, 1, 3, 0);
        Passage passage5 = new Passage(5, 1, 3, 7, 2);
        Passage passage6 = new Passage(6, 1, 2, 4, 0);
        Passage passage7 = new Passage(7, 2, 2, 5, 0);
        Passage passage8 = new Passage(8, 3, 2, 6, 0);
        Passage passage9 = new Passage(9, 4, 1, 8, 0);
        Passage passage10 = new Passage(10, 5, 1, 6, 3);
        Passage passage11 = new Passage(11, 5, 3, 6, 1);
        Passage passage12 = new Passage(12, 4, 2, 7, 0);
        Passage passage13 = new Passage(13, 7, 1, 8, 3);
        Passage passage14 = new Passage(14, 8, 1, 9, 3);
        passage14.setExit(true);

        Passage passage99 = new Passage(99, 99, 99, 99, 99);

        tempPassageList.put(1, passage1);
        tempPassageList.put(2, passage2);
        tempPassageList.put(3, passage3);
        tempPassageList.put(4, passage4);
        tempPassageList.put(5, passage5);
        tempPassageList.put(6, passage6);
        tempPassageList.put(7, passage7);
        tempPassageList.put(8, passage8);
        tempPassageList.put(9, passage9);
        tempPassageList.put(10, passage10);
        tempPassageList.put(11, passage11);
        tempPassageList.put(12, passage12);
        tempPassageList.put(13, passage13);
        tempPassageList.put(14, passage14);
        tempPassageList.put(99, passage99);

        return tempPassageList;
    }

    private static Room roomCreator(int roomId, boolean door1Active, Integer door1PassageId,
                                    boolean door2Active, Integer door2PassageId,
                                    boolean door3Active, Integer door3PassageId,
                                    boolean door4Active, Integer door4PassageId) {


        return new Room(roomId, new Door(0, roomId, door1Active, door1PassageId),
                new Door(1, roomId, door2Active, door2PassageId),
                new Door(2, roomId, door3Active, door3PassageId),
                new Door(3, roomId, door4Active, door4PassageId));
    }
}


