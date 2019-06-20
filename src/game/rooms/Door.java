package game.rooms;

public class Door {

    private int id;
    private boolean active;
    private Integer passageId;
    private int parentRoomId;

    public Door(int id, int parentRoomId, boolean active, Integer passageId) {
        this.id = id;
        this.parentRoomId = parentRoomId;
        this.active = active;
        this.passageId = passageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentRoomId() {
        return parentRoomId;
    }

    public void setParentRoomId(int parentRoomId) {
        this.parentRoomId = parentRoomId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getPassageId() {
        return passageId;
    }

    public void setPassageId(Integer passageId) {
        this.passageId = passageId;
    }

}
