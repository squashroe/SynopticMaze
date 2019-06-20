package game.rooms;

public class Passage {

    private int id = 0;
    private int fromDoorId;
    private int toDoorId;

    public Passage(int id, int fromDoorId, int toDoorId) {
        this.id = id;
        this.fromDoorId = fromDoorId;
        this.toDoorId = toDoorId;
    }

    public int getFromDoorId() {
        return fromDoorId;
    }

    public void setFromDoorId(int fromDoorId) {
        this.fromDoorId = fromDoorId;
    }

    public int getToDoorId() {
        return toDoorId;
    }

    public void setToDoorId(int toDoorId) {
        this.toDoorId = toDoorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

