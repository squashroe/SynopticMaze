package game.engine;

import game.rooms.Door;
import game.rooms.Passage;
import game.rooms.Room;

import java.util.ArrayList;

public class MazeCreator {

    private ArrayList<Room> roomlist = new ArrayList<>();

    public MazeCreator() {
    }
    //here you can create the rooms
    //from that you can then call the doors from the rooms
    //from that you can then call the passages from the doors
    //then pass down the room ID for the passage to know where to send you based on which door you entered.




    public void createAllRooms() {
        Room room1 = roomCreator(1, false, null, true, 2,
                true, 6, true, 5);
        Room room2 = roomCreator(2, true, 1, true, 3,
                true, 7, true, 2);
        Room room3 = roomCreator(3, true, 4, true, 4,
                true, 8 , true, 3);
        Room room4 = roomCreator(4, true, 6, true, 9,
                true, 12, true, 1);
        Room room5 = roomCreator(5, true, 7, true, 10,
                false, null, true, 11);
        Room room6 = roomCreator(6, true, 8, true, 11,
                false, null, true, 10);
        Room room7 = roomCreator(7, true, 12, true, 13,
                true, 5, false, null);
        Room room8 = roomCreator(8, true, 9, true, 14,
                false, null, true, 13);
        Room room9 = roomCreator(9, false, null, false, null,
                false, null, true, 14);

        Passage passage1 =  new Passage(1, 2, 4);
        Passage passage2 =  new Passage(2, 2, 1);
        Passage passage3 =  new Passage(3, 2, 3);
        Passage passage4 =  new Passage(4, 3, 3);
        Passage passage5 =  new Passage(5, 1, 7);
        Passage passage6 =  new Passage(6, 1, 4);
        Passage passage7 =  new Passage(7, 2, 5);
        Passage passage8 =  new Passage(8, 3, 6);
        Passage passage9 =  new Passage(9, 4, 8);
        Passage passage10 = new Passage(10, 5, 6);
        Passage passage11 = new Passage(11, 5, 6);
        Passage passage12 = new Passage(12, 4, 7);
        Passage passage13 = new Passage(13, 7, 8);
        Passage passage14 = new Passage(14, 8, 9);

        roomlist.add(room1);
        roomlist.add(room2);
        roomlist.add(room3);
        roomlist.add(room4);
        roomlist.add(room5);
        roomlist.add(room6);
        roomlist.add(room7);
        roomlist.add(room8);
        roomlist.add(room9);

    }


    public Room roomCreator(int roomId, boolean door1Active, Integer door1PassageId,
                                         boolean door2Active, Integer door2PassageId,
                                          boolean door3Active, Integer door3PassageId,
                                          boolean door4Active, Integer door4PassageId) {

        return new Room(roomId, new Door(0, door1Active, door1PassageId),
                                 new Door(1, door2Active, door2PassageId),
                                 new Door(2, door3Active, door3PassageId),
                                 new Door(3, door4Active, door4PassageId));
    }

    public ArrayList<Room> getRoomlist() {
        return roomlist;
    }
}
