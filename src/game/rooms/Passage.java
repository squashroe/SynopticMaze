package game.rooms;

public class Passage {

    private int id = 0;
    private int fromRoomId;
    private int fromDoorId;
    private int toRoomId;
    private int toDoorId;

    public Passage(int id, int fromRoomId, int fromDoorId, int toRoomId, int toDoorId) {
        this.id = id;
        this.fromRoomId = fromRoomId;
        this.fromDoorId = fromDoorId;
        this.toRoomId = toRoomId;
        this.toDoorId = toDoorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromRoomId() {
        return fromRoomId;
    }

    public void setFromRoomId(int fromRoomId) {
        this.fromRoomId = fromRoomId;
    }

    public int getFromDoorId() {
        return fromDoorId;
    }

    public void setFromDoorId(int fromDoorId) {
        this.fromDoorId = fromDoorId;
    }

    public int getToRoomId() {
        return toRoomId;
    }

    public void setToRoomId(int toRoomId) {
        this.toRoomId = toRoomId;
    }

    public int getToDoorId() {
        return toDoorId;
    }

    public void setToDoorId(int toDoorId) {
        this.toDoorId = toDoorId;
    }
}

